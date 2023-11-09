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
public class TooManyFailedIpLoginsAuthenticationException extends AuthenticationException {
    
    private static final long serialVersionUID = -6313473860143052407L;

    public TooManyFailedIpLoginsAuthenticationException(String s) {
        super(s);
    }
}
