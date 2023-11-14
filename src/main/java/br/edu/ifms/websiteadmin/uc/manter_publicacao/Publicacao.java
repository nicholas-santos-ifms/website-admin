/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_publicacao;

import br.edu.ifms.arch.v010.BaseObject;
import br.edu.ifms.websiteadmin.uc.manter_empresa.Empresa;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import java.time.LocalDateTime;
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
@SequenceGenerator(sequenceName = "publicacao_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Publicacao extends BaseObject {

    @ManyToOne(optional = false)
    private Empresa empresa;
    
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String resumo;
    
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String descricao;
    
    private String urlFoto;
    private LocalDateTime emissao;

}
