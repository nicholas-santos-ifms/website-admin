/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.config;

import br.edu.ifms.websiteadmin.config.filters.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

/**
 *
 * @author nicholas.santos
 */

@Profile(value = {"prod", "dev"})
@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {

    @Autowired
    private AuthenticationProvider authenticationProvider;
    
    @Autowired
    private JwtAuthenticationFilter jwtAuthFilter;
    
    @Autowired
    private LogoutHandler logoutHandler;

    /**
     * MÃ©todo de configuraÃ§Ã£o de seguranÃ§a. MÃ©todo utilizado para configurar a
     * autenticaÃ§Ã£o e a autorizaÃ§Ã£o de acesso ao sistema.
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        /**
         * Prevent the request from being saved
         *
         * @url
         * https://docs.spring.io/spring-security/reference/servlet/architecture.html
         * @date 2023-03-10
         */
        RequestCache nullRequestCache = new NullRequestCache();
        http.requestCache(cache -> cache.requestCache(nullRequestCache));

        /**
         * AutorizaÃ§Ã£o de requisiÃ§Ãµes no servidor
         */
        http.authorizeHttpRequests(authorize
                -> authorize
                        .requestMatchers(HttpMethod.POST, "/api/auth")
                            .permitAll()
                        .requestMatchers("/api/auth/logout")
                            .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuario/forgot-password")
                            .permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/usuario/reset-password")
                            .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/code/verification/*")
                            .permitAll()
                        
                        .requestMatchers(HttpMethod.GET, "/api/produto")
                            .permitAll()
                        // autenticação
                        .requestMatchers("/api/auth", "/api/auth/**").permitAll()
                        // visualização do swagger e do h2
                        .requestMatchers("swagger-ui/**", "v3/api-docs/**", "h2-console/**").permitAll()
                        // exige que a partir daqui qualquer requisição deve exigir autenticação
                        .anyRequest().permitAll()
                        
//                        // exige que a partir daqui qualquer requisiÃ§Ã£o deve exigir autenticaÃ§Ã£o
//                        .anyRequest().authenticated()
        );

        /**
         * ConfiguraÃ§Ã£o do CORS para permitir acesso de aplicaÃ§Ãµes externas
         */
        http.cors();
        /**
         * Desativar proteÃ§Ã£o csrf porque estamos trabalhando com serviÃ§os
         */
        http.csrf((csrf) -> csrf.disable());

        /**
         * NÃ£o utiliza gerenciamento de sessÃµes
         */
        http
                .sessionManagement((session)
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider);
        /**
         * Filtros de controle de autenticaÃ§Ã£o por token
         */
        http.addFilterBefore(
                jwtAuthFilter,
                UsernamePasswordAuthenticationFilter.class)
            .logout(logout -> logout
                // URL padrÃ£o para logout
                .logoutUrl("/api/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication)
                        -> SecurityContextHolder.clearContext())
                .invalidateHttpSession(true));
        return http.build();
    }

}
