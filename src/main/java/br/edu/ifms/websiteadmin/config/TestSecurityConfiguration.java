/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.savedrequest.NullRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

/**
 *
 * @author nicholas.santos
 */
@Profile("test")
@Configuration
@EnableWebSecurity
public class TestSecurityConfiguration {

    /**
     * Método de configura��o de segurança. Método utilizado para configurar a
     * autentica��o e a autoriza��o de acesso ao sistema.
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
         * Autoriza��o de requisições no servidor
         */
        http.authorizeHttpRequests(authorize
                -> authorize
                        .anyRequest()
                        .permitAll()
        );

        /**
         * Configura��o do CORS para permitir acesso de aplicações externas
         */
        http.cors();
        /**
         * Desativar prote��o csrf porque estamos trabalhando com serviços
         */
        http.csrf((csrf) -> csrf.disable());

        /**
         * Não utiliza gerenciamento de sessões
         */
        http
                .sessionManagement((session)
                        -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

}
