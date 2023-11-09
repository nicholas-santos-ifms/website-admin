/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_codigo_chave;

import br.edu.ifms.websiteadmin.manter_usuario.UsuarioNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nicholas.santos
 */
@RestController
@RequestMapping("/api/code")
@Profile(value = {"prod", "dev", "test"})
public class KeyCodeController {

    @Autowired
    private KeyCodeService service;

    @PostMapping
    @Transactional
    public ResponseEntity<?> findById(
            @Valid @RequestBody KeyCodeForm form) {
        try {
            service.enviarCodigoVerificacaoPreInscricao(form);
            return ResponseEntity.ok().build();
        } catch (InvalidKeyException | NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            throw new UsuarioNotFoundException(ex.getMessage());
        }
    }

    @GetMapping("/verification/{code}")
    public ResponseEntity<?> verificacao(
            @PathVariable String code) {
        if (service.isCodigoValido(code)) {
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
