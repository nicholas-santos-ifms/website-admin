/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_uf;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectForm;
import br.edu.ifms.websiteadmin.uc.manter_pais.PaisDto;
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
public class UfForm extends AdapterBaseObjectForm {

    @NotEmpty(message = "A sigla não pode ser vazia.")
    @NotNull(message = "Você deve informar uma sigla.")
    @NotBlank(message = "A sigla não pode ser composta de espaços em branco.")
    private String sigla;
    
    @NotNull(message = "O país deve ser informado.")
    private PaisDto pais;

}
