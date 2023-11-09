/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_produto;

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
public class ProdutoForm extends AdapterBaseObjectForm {

    @NotEmpty(message = "A descri��o n�o pode ser vazia.")
    @NotNull(message = "Voc� deve informar uma descri��o.")
    @NotBlank(message = "A descri��o n�o pode ser composta de espa�os em branco.")
    private String descricao;
    private String urlImagem;
    private String complemento;
    private Boolean ativo;
    
}
