/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_codigo_chave;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author santos
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Chave não encontrada!")
public class KeyCodeNotFoundException extends ResponseStatusException {
    
    private static final long serialVersionUID = 1L;
    
    public KeyCodeNotFoundException(String errorMessage) {
        super(HttpStatus.NOT_FOUND, errorMessage);
    }
}
