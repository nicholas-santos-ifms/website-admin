/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.v010.dto;

import lombok.AllArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author nicho
 */
@SuperBuilder
@AllArgsConstructor
public abstract class AbstractDto {
    
    public abstract Boolean isValido();
    
    protected Boolean isValido(String value) {
        return value != null && (value.isBlank() && value.isEmpty());
    }
}
