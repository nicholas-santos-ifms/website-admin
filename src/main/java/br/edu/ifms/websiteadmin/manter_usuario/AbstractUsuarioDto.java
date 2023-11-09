/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.dto.AdapterBaseObjectDto;
import br.edu.ifms.websiteadmin.manter_arquivo.ArquivoDto;
import br.edu.ifms.websiteadmin.types.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author santos
 */
@Getter
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractUsuarioDto
        extends AdapterBaseObjectDto {
    
    private ArquivoDto foto;
    private Sexo sexo;
    private String telefone;
    private String email;
    private Status status;
    private Boolean enabled;

}
