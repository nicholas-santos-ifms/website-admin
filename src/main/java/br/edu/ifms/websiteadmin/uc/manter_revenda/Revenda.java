/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_revenda;

import br.edu.ifms.arch.v010.BaseObject;
import br.edu.ifms.websiteadmin.uc.manter_cidade.Cidade;
import br.edu.ifms.websiteadmin.uc.manter_empresa.Empresa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.math.BigDecimal;
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
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Entity
@SequenceGenerator(sequenceName = "revenda_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Revenda extends BaseObject {

    private String endereco;
    private String urlLogo;

    @ManyToOne(optional = false)
    private Empresa empresa;

    private BigDecimal longitude;
    private BigDecimal latitude;

    @Column(columnDefinition = "boolean default true")
    private Boolean ativo;

    @ManyToOne(optional = false)
    private Cidade cidade;

}
