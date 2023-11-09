/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.v010.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author santos
 */
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AdapterBaseObjectForm implements IBaseForm  {

    @NotNull(message = "O nome não deve ser nulo")
    @NotEmpty(message = "O nome não deve ser vazio")
    @NotBlank(message = "O Nome não deve conter espaços em branco.")
    @Length(min = 3, message = "O Nome deve conter ao menos 3 caracteres.")
    protected String nome;
    
    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String value) {
        this.nome = value;
    }
}