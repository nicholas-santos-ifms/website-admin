/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_publicacao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author santos
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Publica��o n�o encontrada")
public class PublicacaoNotFoundException extends ResponseStatusException {
    
    private static final long serialVersionUID = 1L;
    
    public PublicacaoNotFoundException(String errorMessage) {
        super(HttpStatus.NOT_FOUND, errorMessage);
    }
}
