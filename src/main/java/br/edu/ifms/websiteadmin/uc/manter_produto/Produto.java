/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_produto;

import br.edu.ifms.arch.v010.BaseObject;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
@SequenceGenerator(sequenceName = "produto_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Produto extends BaseObject {

    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    private String urlImagem;
    
    @Lob
    @Column(columnDefinition = "TEXT")
    private String complemento;
    
    @Column(columnDefinition = "boolean default true")
    private Boolean ativo;

}
