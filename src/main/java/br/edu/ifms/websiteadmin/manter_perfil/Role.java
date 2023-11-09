/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_perfil;

/**
 *
 * @author nicho
 */
public enum Role {
    ROLE_ADMIN(1), ROLE_GERENTE(2), ROLE_COORDENADOR(3),
    ROLE_USUARIO(4), ROLE_AVALIADOR(5), ROLE_ORIENTADOR(6);
    
    int value;
    
    Role(int value) {
        this.value = value;
    }
    
    public int intValue() {
        return value;
    }
    
    public Long longValue() {
        return Long.valueOf(value);
    }
    
    @Override
    public String toString() {
        return switch (value) {
            case 1 -> "ROLE_ADMIN";
            case 2 -> "ROLE_GERENTE";
            case 3 -> "ROLE_COORDENADOR";
            case 4 -> "ROLE_USUARIO";
            case 5 -> "ROLE_AVALIADOR";
            default -> "ROLE_ORIENTADOR";
        };
    }
    
}
