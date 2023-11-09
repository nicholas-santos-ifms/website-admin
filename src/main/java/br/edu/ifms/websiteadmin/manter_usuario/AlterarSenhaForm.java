/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author nicho
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlterarSenhaForm {

    private String email;
    
    @NotEmpty(message = "A nova senha não deve ser vazia.")
    @NotNull(message = "A nova senha deve ser informada.")
    @Size(min = 8, max = 255, message = "A nova senha deve conter no mínimo 8 caracteres")
    private String novaSenha;
    
    @NotEmpty(message = "A Confirmação da senha não deve ser vazia.")
    @NotNull(message = "A Confirmação da senha repetida deve ser informada.")
    @Size(min = 8, max = 255, message = "A Confirmação da senha deve conter no mínimo 8 caracteres")
    private String confirmarSenha;
    
    public Boolean isValido() {
        return novaSenha.equals(confirmarSenha);
    }
}
