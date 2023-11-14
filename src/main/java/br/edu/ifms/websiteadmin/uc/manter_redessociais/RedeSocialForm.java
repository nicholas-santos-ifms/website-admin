/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_redessociais;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author 1513003
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RedeSocialForm extends AdapterBaseObjectForm {

    @NotEmpty(message = "O usu�rio n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um usu�rio.")
    @NotBlank(message = "O usu�rio n�o pode ser composto de espa�os em branco.")
    private String usuario;
    private String urlLogo;

}
