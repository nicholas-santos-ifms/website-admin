/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.manter_autenticacao;

import br.edu.ifms.websiteadmin.manter_usuario.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author santos
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ResetPasswordToken implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "usuario_id")
    private Usuario usuario;

    public Calendar getTimeoutToken(Long resetPasswordTokenExpirationMisiseg) {
        Calendar timeout = Calendar.getInstance();
        timeout.setTimeInMillis(this.createdDate.getTime() + resetPasswordTokenExpirationMisiseg);
        return timeout;
    }

    public boolean isExpired(Long resetPasswordTokenExpirationMisiseg) {
        return getTimeoutToken(resetPasswordTokenExpirationMisiseg).before(new Date());
    }

}
