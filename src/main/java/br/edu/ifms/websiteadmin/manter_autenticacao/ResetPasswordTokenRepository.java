/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.manter_autenticacao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author santos
 */
public interface ResetPasswordTokenRepository extends JpaRepository<ResetPasswordToken, Long> {
    
    Optional<ResetPasswordToken> findByToken(String token);
    
}