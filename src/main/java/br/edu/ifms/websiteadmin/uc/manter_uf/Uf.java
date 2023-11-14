/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_uf;

import br.edu.ifms.arch.v010.BaseObject;
import br.edu.ifms.websiteadmin.uc.manter_pais.Pais;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
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
@SequenceGenerator(sequenceName = "uf_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Uf extends BaseObject {

    @Lob
    @Column(nullable = false)
    private String sigla;

    @ManyToOne(optional = false)
    private Pais pais;
    
}
