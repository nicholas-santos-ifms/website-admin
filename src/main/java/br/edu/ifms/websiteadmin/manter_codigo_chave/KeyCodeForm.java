/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_codigo_chave;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author nicholas.santos
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class KeyCodeForm extends AdapterBaseObjectForm {

    @NotEmpty(message = "O E-mail não deve ser vazio.")
    @NotNull(message = "O E-mail deve ser informado.")
    @Email(message = "Você deve informar um e-mail válido.")
    private String email;

    @NotEmpty(message = "Senha não deve ser vazio.")
    @NotNull(message = "A senha deve ser informada.")
    private String senha;

}
