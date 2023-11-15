/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_codigo_chave;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.openauthentication.otp.OneTimePasswordAlgorithm;

/**
 *
 * @author nicholas.santos
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KeyCode {

    @Id
    private String code;
    private String mail;
    private String password;
    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    /**
     * Gera o cÃ³digo de verificação de 6 dÃ­gitos
     * @param mail
     * @return 
     * @throws java.security.NoSuchAlgorithmException
     * @throws java.security.InvalidKeyException
     */
    public static String generateCode(String mail) throws NoSuchAlgorithmException, InvalidKeyException {
        String secret = LocalDateTime.now().toString().concat(mail);
        return OneTimePasswordAlgorithm.generateOTP(
                secret.getBytes(), 2, 6,
                false, 0);
    }

    public boolean isExpired(Long resetPasswordTokenExpirationMisiseg) {
        Long now = System.currentTimeMillis();
        Long difference = now - this.createdAt
                .atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return difference > resetPasswordTokenExpirationMisiseg;
    }
    

}
