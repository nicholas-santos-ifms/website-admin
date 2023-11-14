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

    @NotEmpty(message = "O CELULAR não pode ser vazio.")
    @NotNull(message = "Você deve informar um CELULAR.")
    @NotBlank(message = "O CELULAR não pode ser composto de espaços em branco.")
    private String celular;
    
    @NotEmpty(message = "O TELEFONE não pode ser vazio.")
    @NotNull(message = "Você deve informar um TELEFONE.")
    @NotBlank(message = "O TELEFONE não pode ser composto de espaços em branco.")
    private String telefone;
    
    @NotEmpty(message = "O EMAIL não pode ser vazio.")
    @NotNull(message = "Você deve informar um celular.")
    @NotBlank(message = "O EMAIL não pode ser composto de espaços em branco.")
    @Email(message = "Você deve informar um e-mail válido")
    private String email;
    
    @NotEmpty(message = "O CNPJ não pode ser vazio.")
    @NotNull(message = "Você deve informar um CNPJ.")
    @NotBlank(message = "O CNPJ não pode ser composto de espaços em branco.")
    @CNPJ
    private String cnpj;
    
    @NotEmpty(message = "A MISSÃO não pode ser vazia.")
    @NotNull(message = "Você deve informar uma MISSÃO.")
    @NotBlank(message = "A MISSÃO não pode ser composta de espaços em branco.")
    private String missao;
    
    @NotEmpty(message = "A VISÃO DA EMPRESA não pode ser vazio.")
    @NotNull(message = "Você deve informar uma VISÃO DA EMPRESA.")
    @NotBlank(message = "A VISÃO DA EMPRESA não pode ser composta de espaços em branco.")
    private String visao;
    
    @NotEmpty(message = "O VALOR DA EMPRESA não pode ser vazio.")
    @NotNull(message = "Você deve informar um VALOR DA EMPRESA.")
    @NotBlank(message = "O VALOR DA EMPRESA não pode ser composto de espaços em branco.")
    private String valores;
    
    @NotEmpty(message = "O SOBRE DA EMPRESA não pode ser vazio.")
    @NotNull(message = "Você deve informar um SOBRE DA EMPRESA.")
    @NotBlank(message = "O SOBRE DA EMPRESA não pode ser composto de espaços em branco.")
    private String sobre;
    
}
