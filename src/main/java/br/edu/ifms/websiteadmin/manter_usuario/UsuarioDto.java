/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.websiteadmin.manter_perfil.Perfil;
import java.util.List;
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
public class UsuarioDto extends AbstractUsuarioDto {

    private String cpf;
    private TipoNotificacao tipoNotificacao;
    private List<Perfil> perfis;

}
