/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.controller.AbstractLeanController;
import br.edu.ifms.websiteadmin.exception.MessageDto;
import br.edu.ifms.websiteadmin.manter_autenticacao.ChangePasswordRequest;
import br.edu.ifms.websiteadmin.manter_autenticacao.ForgotPasswordRequest;
import br.edu.ifms.websiteadmin.manter_autenticacao.UserServiceAuthenticationException;
import br.edu.ifms.websiteadmin.manter_codigo_chave.KeyCodeService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author santos
 */
@RestController
@RequestMapping("/api/usuario")
@Profile(value = {"prod", "test", "dev"})
public class UsuarioController
        extends AbstractLeanController<
        Usuario, Long, UsuarioDto, UsuarioLeanDto, UsuarioForm, UsuarioRepository, UsuarioService> {

    @Autowired
    private KeyCodeService keyCodeService;

    @Autowired
    @Override
    public void setService(UsuarioService service) {
        super.service = service;
        super.setMapper(UsuarioMapper.INSTANCE);
    }

    @Override
    public URI createUri(Usuario entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/usuario/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GERENTE')")
    @GetMapping
    public ResponseEntity<Page<UsuarioLeanDto>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String status,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao
    ) {

        Page<Usuario> page = service.listar(nome, null, status, paginacao);

        return ResponseEntity.ok(
                UsuarioMapper.INSTANCE.toLeanDtoPage(page)
        );
    }

    @Override
    @GetMapping("/not-supported")
    public ResponseEntity<Page<UsuarioLeanDto>> listarLean(Pageable paginacao) {
        return ResponseEntity.notFound().build();
    }

//    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GERENTE') or hasRole('ROLE_COORDENADOR')")
    @GetMapping("/list")
    @Override
    public List<UsuarioLeanDto> listarLean() {
        return UsuarioMapper.INSTANCE.toLeanDtoList(service.listar());
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UsuarioDto> visualizar(
            @PathVariable String email) {
        Optional<Usuario> op = service.buscarPor(email);
        if (op.isPresent()) {
            return ResponseEntity.ok(UsuarioMapper.INSTANCE.toDto(op.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/alterar-senha")
    @Transactional
    public ResponseEntity<UsuarioDto> alterarSenha(
            @RequestBody @Valid AlterarSenhaForm form,
            UriComponentsBuilder uriBuilder) throws IOException {
        Usuario obj = service.alterarSenha(form);

        URI uri = uriBuilder.path("/api/usuario/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(UsuarioMapper.INSTANCE.toDto(obj));
    }

    @PostMapping("/not-used")
    @Override
    public ResponseEntity<UsuarioDto> cadastrar(UsuarioForm form, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GERENTE')")
    @PostMapping
    @Transactional
    public ResponseEntity<UsuarioDto> cadastrar(
            @RequestParam(required = false, name = "file") MultipartFile file,
            @RequestPart("form") @Valid UsuarioForm form,
            UriComponentsBuilder uriBuilder) throws IOException {

        Usuario obj = service.criar(form, file);

        URI uri = uriBuilder.path("/api/usuario/{id}")
                .buildAndExpand(obj.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(mapper.toDto(obj));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GERENTE')")
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UsuarioDto> atualizar(
            @PathVariable Long id,
            @RequestParam(required = false, name = "file") MultipartFile file,
            @RequestPart("form") @Valid UsuarioForm form) throws IOException {
        Usuario t = service.atualizar(id, form, file);
        if (t != null) {
            return ResponseEntity.ok(UsuarioMapper.INSTANCE.toDto(t));
        }
        return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GERENTE')")
    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<?> ativar(@PathVariable Long id) {
        service.ativar(id);
        return ResponseEntity.ok().build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_GERENTE')")
    @PutMapping("/bloquear/{id}")
    @Transactional
    public ResponseEntity<?> bloquear(@PathVariable Long id) {
        service.bloquear(id);
        return ResponseEntity.ok().build();
    }

    @Override
    @PutMapping("not-suported/{id}")
    @Transactional
    public ResponseEntity<UsuarioDto> atualizar(Long id, UsuarioForm form) {
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request)
            throws NoSuchAlgorithmException, InvalidKeyException,
            URISyntaxException, IOException {
        Optional<Usuario> optional = service
                .buscarPor(request.getEmail());
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST.value()).body(
                    new MessageDto(HttpStatus.BAD_REQUEST.value(),
                            "Erro de Solicitação",
                            "O e-mail informado não está cadastrado no sistema.")
            );
        }

        Usuario usuario = optional.get();
        /**
         * Gera o token para realização de alteração de senha
         */
        var keyCode = keyCodeService.gerarCodigoVerificacao(usuario.getEmail(), "");
        /**
         * Envia o código gerado para o e-mail do usuário
         */
        keyCodeService.enviarCodigoPorEmail(keyCode);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> findById(@Valid @RequestBody ChangePasswordRequest form) {
        if (!form.getNovaSenha().equals(form.getConfirmarSenha())) {
            throw new UserServiceAuthenticationException(
                    "A nova senha e a senha de confirmação não combinam!"
            );
        }

        var code = form.getKeyCode();
        if (keyCodeService.isCodigoValido(code)) {
            var keyCode = keyCodeService.buscarPor(code).get();
            keyCode.setPassword(form.getNovaSenha());
            service.resetPassword(keyCode);
            /**
             * Exclui o código após a alteração da senha
             */
            keyCodeService.desativarCodigosPor(keyCode.getMail());
            return ResponseEntity.ok().body(new MessageDto(HttpStatus.OK.value(), "Senha alterada com sucesso!"));
        }
        return ResponseEntity.notFound().build();
    }
}
