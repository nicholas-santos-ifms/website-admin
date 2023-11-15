/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.manter_autenticacao;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author santos
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChangePasswordRequest {

    @NotNull
    private String keyCode;

    @NotEmpty(message = "A nova senha n√£o deve ser vazia.")
    @NotNull(message = "A nova senha deve ser informada.")
    @Size(min = 8, max = 255, message = "A nova senha deve conter no m√≠nimo 8 caracteres")
    private String novaSenha;
    
    @NotEmpty(message = "A ConfirmaÁ„o da senha n√£o deve ser vazia.")
    @NotNull(message = "A ConfirmaÁ„o da senha repetida deve ser informada.")
    @Size(min = 8, max = 255, message = "A ConfirmaÁ„o da senha deve conter no m√≠nimo 8 caracteres")
    private String confirmarSenha;

}
