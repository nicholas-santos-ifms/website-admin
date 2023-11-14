/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_empresa;

import br.edu.ifms.websiteadmin.uc.manter_produto.*;
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
@SequenceGenerator(sequenceName = "empresa_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Empresa extends BaseObject {

    @Column(nullable = false)
    private String celular;
    
    @Column(nullable = false)
    private String telefone;
    
    @Column(nullable = false)
    private String email;
    
    @Column(nullable = false)
    private String cnpj;
    
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String missao;
    
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String visao;
    
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String valores;
    
    @Lob
    @Column(nullable = false, columnDefinition = "TEXT")
    private String sobre;

}
