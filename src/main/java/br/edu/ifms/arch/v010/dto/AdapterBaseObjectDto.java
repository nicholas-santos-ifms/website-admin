/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.v010.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.util.StringUtils;


/**
 *
 * @author santos
 */
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdapterBaseObjectDto
        extends AbstractDto
        implements IBasicDto {

    @NotNull(message = "O id deve ser informado")
    private Long id;
    
    @NotNull(message = "O nome deve ser informado")
    @NotEmpty(message = "O nome não deve ser vazio")
    @NotBlank(message = "O nome não deve conter somente espaços em branco")
    private String nome;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }
    
    @Override
    public Boolean isValido() {
        return StringUtils.hasText(nome);
    }

}