/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.uc.manter_pais;

import br.edu.ifms.arch.v010.BaseObject;
import jakarta.persistence.Entity;
import jakarta.persistence.SequenceGenerator;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 *
 * @author santos
 */
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@NoArgsConstructor
@SequenceGenerator(sequenceName = "pais_sequence", name = "baseObjectSequence", allocationSize = 1)
public class Pais extends BaseObject implements Serializable {

}
