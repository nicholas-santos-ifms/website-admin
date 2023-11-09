package br.edu.ifms.websiteadmin.manter_autenticacao;

import br.edu.ifms.websiteadmin.manter_usuario.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/auth")
@Profile(value = {"prod", "dev"})
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService service;

    @PostMapping
    public ResponseEntity<AutenticacaoResponse> authenticate(
            @NonNull HttpServletRequest request,
            @NonNull HttpServletResponse response,
            @RequestBody AutenticacaoRequest authRequest
    ) {
        return ResponseEntity.ok(service.autenticar(
                request,
                response,
                authRequest));
    }
}
