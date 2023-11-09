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
public class TooManyFailedLoginsAuthenticationException extends AuthenticationException {
    
    private static final long serialVersionUID = 5368673516685167890L;

    public TooManyFailedLoginsAuthenticationException(String s) {
        super(s);
    }
}
