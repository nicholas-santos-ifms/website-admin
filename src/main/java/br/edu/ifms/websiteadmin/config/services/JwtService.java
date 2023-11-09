/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.config.services;

import br.edu.ifms.websiteadmin.manter_usuario.UsuarioNotFoundException;
import br.edu.ifms.websiteadmin.properties.RpasProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.security.SignatureException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import static org.hibernate.query.sqm.SqmTreeTransformationLogger.LOGGER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author nicho
 */
@Service
public class JwtService {

    @Autowired
    private RpasProperties props;

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extração de claim. Método criado para extrair dados (claim) do token
     *
     * @param <T>
     * @param token
     * @param claimsResolver
     * @return
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String generateToken(UserDetails userDetails) {
        return generateToken(new HashMap<>(), userDetails);
    }

    /**
     * Geração do token. Método usado para criar um token baseado no usuário e
     * em propriedades (claims) adicionais
     *
     * @param extraClaims
     * @param userDetails
     * @return
     */
    public String generateToken(
            Map<String, Object> extraClaims,
            UserDetails userDetails) {
        long expirationAdd = props.getJwt().getExpiration().toMillis();
        Date issueAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(System.currentTimeMillis() + expirationAdd);

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(issueAt)
                .setExpiration(expiration)
                .signWith(getSignKey(), SignatureAlgorithm.HS512)
                .compact();
    }

    public Boolean isTokenValid(String token, UserDetails user) {
        final String username = extractUsername(token);
        return (user != null
                && username.equals(user.getUsername())
                && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token)
                .before(new Date());
    }

    private Claims extractAllClaims(String token) {
        try {
            var parser = Jwts
                    .parserBuilder()
                    .setSigningKey(getSignKey())
                    .build();
            var claims = parser
                    .parseClaimsJws(token)
                    .getBody();
            return claims;
        } catch (ExpiredJwtException e) {
            LOGGER.debug(e.getMessage(), e.getCause());
            throw new UsuarioNotFoundException("Token expirado");
        } catch (UnsupportedJwtException | MalformedJwtException | IllegalArgumentException e) {
            LOGGER.debug(e.getMessage(), e.getCause());
            throw new UsuarioNotFoundException("Token inválido");
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e.getCause());
            throw new UsuarioNotFoundException(e.getMessage());
        }
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(props.getJwt().getSecret());
        return Keys.hmacShaKeyFor(keyBytes);
    }

}
