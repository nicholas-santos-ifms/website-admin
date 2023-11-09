/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import br.edu.ifms.websiteadmin.manter_perfil.PerfilDto;
import br.edu.ifms.websiteadmin.types.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author santos
 */
@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioForm
        extends AdapterBaseObjectForm {

    @NotEmpty(message = "O E-mail não deve ser vazio.")
    @NotNull(message = "O E-mail deve ser informado.")
    @NotBlank(message = "O E-mail não deve conter somente espaços em branco")
    @Email(message = "Você deve informar um e-mail válido.")
    private String email;

//    @NotEmpty(message = "O CPF não deve ser vazio.")
//    @NotNull(message = "O CPF não deve ser vazio.")
//    @NotBlank(message = "O CPF não deve conter somente espaços em branco")
//    @Cpf
    private String cpf;

    @NotNull(message = "O Sexo deve ser informado.")
    private Sexo sexo;

    private String telefone;

    private Status status;

    private boolean enabled;

    private List<PerfilDto> perfis;
    
}
