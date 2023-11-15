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
     * Método de configuração de segurança. Método utilizado para configurar a
     * autenticação e a autorização de acesso ao sistema.
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
         * Autorização de requisiçÃƒÂµes no servidor
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
                        
                        .requestMatchers(HttpMethod.GET, "/api/produto", "/api/produto/*")
                            .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/cidade", "/api/cidade/*")
                            .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/pais", "/api/pais/*")
                            .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/uf", "/api/uf/*")
                            .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/rede-social", "/api/rede-social/*")
                            .permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/publicacao", "/api/publicacao/*")
                            .permitAll()
                        // autenticação
                        .requestMatchers("/api/auth", "/api/auth/**").permitAll()
                        // visualização do swagger e do h2
                        .requestMatchers("swagger-ui/**", "h2-console/**").permitAll()
                        // exige que a partir daqui qualquer requisição deve exigir autenticação
                        .anyRequest().permitAll()
                        
                        // exige que a partir daqui qualquer requisição deve exigir autenticação
                        .anyRequest().authenticated()
        );

        /**
         * Configuração do CORS para permitir acesso de aplicaçÃƒÂµes externas
         */
        http.cors();
        /**
         * Desativar proteção csrf porque estamos trabalhando com serviços
         */
        http.csrf((csrf) -> csrf.disable());

        /**
         * Não utiliza gerenciamento de sessÃƒÂµes
         */
        http
                .sessionManagement((session)
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider);
        /**
         * Filtros de controle de autenticação por token
         */
        http.addFilterBefore(
                jwtAuthFilter,
                UsernamePasswordAuthenticationFilter.class)
            .logout(logout -> logout
                // URL padrão para logout
                .logoutUrl("/api/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication)
                        -> SecurityContextHolder.clearContext())
                .invalidateHttpSession(true));
        return http.build();
    }

}
