/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_empresa;

import br.edu.ifms.websiteadmin.uc.manter_produto.*;
import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author 1513003
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EmpresaForm extends AdapterBaseObjectForm {

    @NotEmpty(message = "O CELULAR n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um CELULAR.")
    @NotBlank(message = "O CELULAR n�o pode ser composto de espa�os em branco.")
    private String celular;
    
    @NotEmpty(message = "O TELEFONE n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um TELEFONE.")
    @NotBlank(message = "O TELEFONE n�o pode ser composto de espa�os em branco.")
    private String telefone;
    
    @NotEmpty(message = "O EMAIL n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um celular.")
    @NotBlank(message = "O EMAIL n�o pode ser composto de espa�os em branco.")
    @Email(message = "Voc� deve informar um e-mail v�lido")
    private String email;
    
    @NotEmpty(message = "O CNPJ n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um CNPJ.")
    @NotBlank(message = "O CNPJ n�o pode ser composto de espa�os em branco.")
    @CNPJ
    private String cnpj;
    
    @NotEmpty(message = "A MISS�O n�o pode ser vazia.")
    @NotNull(message = "Voc� deve informar uma MISS�O.")
    @NotBlank(message = "A MISS�O n�o pode ser composta de espa�os em branco.")
    private String missao;
    
    @NotEmpty(message = "A VIS�O DA EMPRESA n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar uma VIS�O DA EMPRESA.")
    @NotBlank(message = "A VIS�O DA EMPRESA n�o pode ser composta de espa�os em branco.")
    private String visao;
    
    @NotEmpty(message = "O VALOR DA EMPRESA n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um VALOR DA EMPRESA.")
    @NotBlank(message = "O VALOR DA EMPRESA n�o pode ser composto de espa�os em branco.")
    private String valores;
    
    @NotEmpty(message = "O SOBRE DA EMPRESA n�o pode ser vazio.")
    @NotNull(message = "Voc� deve informar um SOBRE DA EMPRESA.")
    @NotBlank(message = "O SOBRE DA EMPRESA n�o pode ser composto de espa�os em branco.")
    private String sobre;
    
}
