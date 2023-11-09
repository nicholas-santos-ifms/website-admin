/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_autenticacao;

import org.springframework.security.core.AuthenticationException;

/**
 *
 * @author santos
 */
public class UserServiceAuthenticationException extends AuthenticationException {
    
    private static final long serialVersionUID = 6356844005269578058L;

    public UserServiceAuthenticationException(String s) {
        super(s);
    }
}
