/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_autenticacao;

import br.edu.ifms.websiteadmin.manter_rastreamento_ip.IpLog;
import br.edu.ifms.websiteadmin.manter_rastreamento_ip.IpTracker;
import br.edu.ifms.websiteadmin.manter_usuario.Usuario;
import br.edu.ifms.websiteadmin.manter_usuario.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author santos
 */
@RequiredArgsConstructor
public class LoginAttemptsUtil {

    private static final Logger LOG = LoggerFactory.getLogger(LoginAttemptsUtil.class);
    private static final int MAX_FAILED_LOGINS = 4;
    private static final long FAILED_LOGIN_TIMEOUT_PERIOD = 24 * 3600 * 1000;

    private final UsuarioService usuarioService;
    private final IpTracker ipTracker;

    public void checkMaxLoginAttempts(AutenticacaoRequest jwtRequest) {
        LOG.debug("Checking for too many failed logins");

        if (jwtRequest != null && jwtRequest.getEmail() != null) {
            Usuario user = usuarioService.loadUserByUsername(jwtRequest.getEmail());
            checkForFailedLogins(user);
        } else {
            throw new UserServiceAuthenticationException("Não é possível efetuar o login!");
        }
    }

    private void checkForFailedLogins(Usuario user) {
        if (user.getFailedAttempt()!= null) {
            if (user.getFailedAttempt() >= MAX_FAILED_LOGINS) {
                checkDateThreshold(user);
            }
        }
    }

    private void checkDateThreshold(Usuario user) {
        if (user.getLastFailedLoginTime() != null) {
            Long now = System.currentTimeMillis();
            Long difference = now - user.getLastFailedLoginTime();

            if (difference < FAILED_LOGIN_TIMEOUT_PERIOD) {
                throw new TooManyFailedLoginsAuthenticationException("Muitas tentativas de login sem sucesso! Entre em contato com o Administrador do Sistema.");
            }
        }
    }

    /**
     * Check to make sure this user hasn't failed authentication too many times
     * from the same IP address.
     * @param request
     */
    public void checkIpValidity(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();

        //timeframe in the past 24 hours
        Long timeframe = System.currentTimeMillis() - FAILED_LOGIN_TIMEOUT_PERIOD;

        List<IpLog> list = ipTracker.fetchIpFailureRecord(ipAddress, timeframe);
        if (list != null && list.size() >= MAX_FAILED_LOGINS) {
            throw new TooManyFailedIpLoginsAuthenticationException("Muitas tentativas de login sem sucesso para o mesmo IP!");
        }
    }
}
