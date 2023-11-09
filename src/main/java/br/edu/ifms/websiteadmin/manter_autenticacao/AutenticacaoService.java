/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_autenticacao;

import br.edu.ifms.websiteadmin.config.services.JwtService;
import br.edu.ifms.websiteadmin.manter_rastreamento_ip.IpTracker;
import br.edu.ifms.websiteadmin.manter_token.Token;
import br.edu.ifms.websiteadmin.manter_token.TokenRepository;
import br.edu.ifms.websiteadmin.manter_token.TokenType;
import br.edu.ifms.websiteadmin.manter_usuario.Usuario;
import br.edu.ifms.websiteadmin.manter_usuario.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicho
 */
@Service
@RequiredArgsConstructor
public class AutenticacaoService {

    private final UsuarioService usuarioService;
    private final IpTracker ipTracker;
    private final TokenRepository tokenRepository;

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AutenticacaoResponse autenticar(
            HttpServletRequest request,
            HttpServletResponse response,
            AutenticacaoRequest authRequest) {
        LoginAttemptsUtil loginAttemptsUtil = new LoginAttemptsUtil(usuarioService, ipTracker);
        try {
            loginAttemptsUtil.checkMaxLoginAttempts(authRequest);
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            authRequest.getEmail(),
                            authRequest.getSenha()
                    )
            );

            var user = usuarioService.buscarPor(authRequest.getEmail())
                    .orElseThrow();
            
            var token = jwtService.generateToken(user);
            //log a successful authentication to iplog collection
            ipTracker.successfulLogin(
                    user.getUsername(),
                    request.getRemoteAddr());

            //log a successful authentication to user collection
            usuarioService.successfulLogin(user.getUsername());
            /**
             * Desabilita os tokens ativos e grava um novo
             */
            revokeAllUserTokens(user);
            saveUserToken(user, token);

            return AutenticacaoResponse.builder()
                    .token(token)
                    .build();
        } catch (BadCredentialsException ex) {
            //gotta log to both the user service and ip tracker
            //because the user service tracks failed login attempts per user
            //while the ip tracker tracks failed login attempts per ip
            usuarioService.updateFailedLoginAttempts(authRequest.getEmail());
            ipTracker.unsuccessfulLogin(authRequest.getEmail(), request.getRemoteAddr());
            
            throw new InvalidCredentialsAuthenticationException("Usuário ou senha Inválidos!");
        }
    }

    private void revokeAllUserTokens(Usuario user) {
        var validUserTokens = tokenRepository
                .findAllValidTokenByUser(user.getId());
        if (validUserTokens.isEmpty()) {
            return;
        }
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(Usuario user, String jwtToken) {
        var token = Token.builder()
                .usuario(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

}
