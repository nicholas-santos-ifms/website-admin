/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.service.AbstractBasicService;
import br.edu.ifms.websiteadmin.manter_codigo_chave.KeyCode;
import br.edu.ifms.websiteadmin.manter_perfil.Perfil;
import br.edu.ifms.websiteadmin.manter_perfil.Role;
import br.edu.ifms.websiteadmin.types.Status;
import jakarta.persistence.criteria.Join;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author santos
 */
@Service
public class UsuarioService
        extends AbstractBasicService<
            Usuario, Long, UsuarioForm, UsuarioRepository>
        implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    @Override
    public void setRepository(UsuarioRepository repository) {
        super.repository = repository;
        super.setMapper(UsuarioMapper.INSTANCE);
    }

    public Usuario criar(UsuarioForm form,
            MultipartFile foto) {
        try {
            this.validate();

            /**
             * Verifica se já existe usuário cadastrado com e-mail ou cpf
             * informados
             */
            var optional = buscarPor(form.getEmail(), form.getCpf());
            if (optional.isPresent()) {
                var msg = "Já existe usuário cadastrado com o E-mail ou CPF informado.";
                throw new UsuarioNotFoundException(msg);
            }

            var t = UsuarioMapper.INSTANCE
                    .formToEntityWithFile(form, foto);
            return repository.save(t);
        } catch (IOException ex) {
            throw new UsuarioNotFoundException("Não foi possível carregar a foto do usuário");
        }
    }

    public Usuario atualizar(Long id,
            UsuarioForm form,
            MultipartFile foto) {
        var msg = "Não existe usuário com o código %d.";
        return buscarPor(id)
                .map(entity -> {
                    try {
                        return UsuarioMapper.INSTANCE
                                .updateWithFile(form, entity, foto);
                    } catch (IOException ex) {
                        throw new UsuarioNotFoundException(
                                "Não foi possível carregar a foto do usuário.");
                    }
                })
                .orElseThrow(() -> new UsuarioNotFoundException(
                String.format(msg, id)));
    }

    @Override
    public Usuario atualizar(Long id, UsuarioForm form) {
        return super.atualizar(id, form); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public Usuario buscarUsuarioLogado() {
        var principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal != null && !"anonymousUser".equals(principal)) {
            var logado = (Usuario) principal;

            return buscarPor(logado.getId())
                    .orElseThrow(() -> new UsuarioNotFoundException("Não existe usuário logado!"));
        }
        return null;
    }

    /**
     * Criação dos filtros. Método responsável por criar os filtros de busca
     * para listagem de usuários
     *
     * @param nome Busca por qualquer parte do nome
     * @param perfilId Filtra os usuários pelo ID do perfil
     * @param status Filtra os usuários de acordo com seu STATUS
     * @return
     */
    private List<Specification<Usuario>> createFilters(
            String nome,
            Long perfilId,
            String status) {

        List<Long> perfisId = null;
        if (perfilId != null && perfilId > 0) {
            perfisId = Arrays.asList(perfilId);
        }

        return createFilters(nome, perfisId, status);
    }

    private List<Specification<Usuario>> createFilters(
            String nome,
            List<Long> perfisId,
            String status) {
        List<Specification<Usuario>> l = new ArrayList();

        if (StringUtils.hasText(nome)) {
            Specification<Usuario> spec = (root, query, criteriaBuilder)
                    -> criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("nome")),
                            "%" + nome.toUpperCase() + "%");
            l.add(spec);
        }

        if (perfisId != null && !perfisId.isEmpty()) {
            Specification<Usuario> spec = (root, query, criteriaBuilder) -> {
                Join<Perfil, Usuario> join = root.join("perfis");
                var inClause = criteriaBuilder.in(join.get("perfil").get("id"));
                for (var item : perfisId) {
                    inClause.value(item);
                }

                return inClause;
            };
            l.add(spec);
        }

        if (status != null && !"null".equals(status) && StringUtils.hasText(status)) {
            Status s = Status.valueOf(status);
            Specification<Usuario> spec = (root, query, criteriaBuilder)
                    -> criteriaBuilder.equal(root.get("status"), s);
            l.add(spec);
        }

        return l;
    }

    public Page<Usuario> listarOrientadores(
            String nome,
            String status,
            Pageable paginacao) {
        var selectedPerfilId = Role.ROLE_ORIENTADOR.longValue();
        return listar(nome, selectedPerfilId, status, paginacao);
    }

    /**
     * Listagem paginada de usuários.Este método tem o objetivo de listar
     * usuários de acordo com os parâmetros informados.
     *
     * @param nome Busca por qualquer parte do nome
     * @param perfilId Filtra os usuários pelo ID do perfil
     * @param status Filtra os usuários de acordo com seu STATUS
     * @param paginacao Paginação a ser aplicada na busca
     * @return
     */
    public Page<Usuario> listar(
            String nome,
            Long perfilId,
            String status,
            Pageable paginacao) {
        List<Specification<Usuario>> l = createFilters(nome, perfilId, status);

        if (l.isEmpty()) {
            return repository.findAll(paginacao);
        }

        Specification<Usuario> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result, paginacao);
    }

    /**
     * Listagem de usuários. Este método tem o objetivo de listar usuários de
     * acordo com os parâmetros informados.
     *
     * @param nome Busca por qualquer parte do nome
     * @param perfilId Filtra os usuários pelo ID do perfil
     * @param status Filtra os usuários de acordo com seu STATUS
     * @return
     */
    public List<Usuario> listar(
            String nome,
            Long perfilId,
            String status) {
        List<Long> perfisId = new ArrayList();
        if (perfilId != null && perfilId > 0) {
            perfisId = Arrays.asList(perfilId);
        }
        return listar(nome, perfisId, status);
    }

    /**
     * Listagem de usuários. Este método tem o objetivo de listar usuários de
     * acordo com os parâmetros informados.
     *
     * @param nome Busca por qualquer parte do nome
     * @param perfisId Filtra os usuários pelo conjunto de IDs do perfil
     * @param status Filtra os usuários de acordo com seu STATUS
     * @return
     */
    public List<Usuario> listar(
            String nome,
            List<Long> perfisId,
            String status) {
        List<Specification<Usuario>> l = createFilters(nome, perfisId, status);

        Sort sort = Sort.by(Order.by("nome"));
        if (l.isEmpty()) {
            return repository.findAll(sort);
        }

        Specification<Usuario> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result, sort);
    }

    @Override
    public List<Usuario> listar() {
        List<Specification<Usuario>> l = new ArrayList();

        /**
         * Trazer somente os usuários ativos
         */
        Specification<Usuario> spec = (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(root.get("status"), Status.ATIVO);
        l.add(spec);

        Specification<Usuario> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result);
    }

    public List<Usuario> listarAtivos() {
        return repository.findByStatusAndEnabled(
                Status.ATIVO,
                Boolean.TRUE);
    }

    @Override
    public Optional<Usuario> buscarPor(Long id) {
        return repository.findDetailUsuarioById(id);
    }

    public Usuario buscarUsuarioAtivo(Long id) {
        return repository.findUsuarioEnabledById(id)
                .orElseThrow(() -> new UsuarioNotFoundException(
                String.format("Não existe Usuario com o código %d.",
                        id)));
    }

    public Optional<Usuario> buscarPor(String email) {
        return repository.findByEmail(email);
    }

    public Optional<Usuario> buscarPor(String email, String cpf) {
        if (StringUtils.hasText(cpf)) {
            return repository.findByEmailOrCpf(email, cpf);
        }
        return repository.findByEmail(email);
    }

    @Override
    public Usuario loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optional = buscarPor(username);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    public Usuario alterarSenha(AlterarSenhaForm form) {
        if (!form.isValido()) {
            throw new UsuarioNotFoundException("A confirmação da senha deve ser igual a nova senha informada!");
        }

        return repository
                .findByEmailAndStatusAndEnabled(form.getEmail(), Status.ATIVO, true)
                .map(entity -> {
                    resetPassword(entity, form.getNovaSenha());
                    return entity;
                })
                .orElseThrow(
                        () -> new UsuarioNotFoundException("Dados inválidos!")
                );
    }

    public void resetPassword(KeyCode keyCode) {
        var op = repository.findByEmail(keyCode.getMail());
        if (op.isPresent()) {
            Usuario u = op.get();
            resetPassword(u, keyCode.getPassword());
        } else {
            throw new UsuarioNotFoundException("Dados inválidos!");
        }
    }

    public void resetPassword(Usuario usuario, String password) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        repository.setSenhaFor(
                usuario.getEmail(),
                encoder.encode(password));
    }

    public Optional<Usuario> resetPassword(String token, String password) {
        Optional<Usuario> optional = repository
                .findByEmailAndStatusAndEnabled(token,
                        Status.ATIVO, Boolean.TRUE);
        if (optional.isPresent()) {
            Usuario usuario = optional.get();
            resetPassword(usuario, password);
        }

        return optional;
    }

    public void updateFailedLoginAttempts(String username) {
        try {
            Optional<Usuario> op = repository.findByEmail(username);
            Usuario user = op.get();

            Integer failedLoginAttempts = user.getFailedAttempt();
            if (failedLoginAttempts == null) {
                failedLoginAttempts = 1;
            } else {
                failedLoginAttempts++;
            }

            user.setFailedAttempt(failedLoginAttempts);
            user.setLastFailedLoginTime(System.currentTimeMillis());

            repository.save(user);
        } catch (UsernameNotFoundException e) {
            LOG.error("Problem attempting to update failed login attempts!", e);
        }
    }

    public void successfulLogin(String username) {
        resetFailedLoginAttempts(username);
    }

    private void resetFailedLoginAttempts(String username) {
        Optional<Usuario> op = repository.findByEmail(username);
        Usuario user = op.get();

        Integer failedLoginAttempts = user.getFailedAttempt();
        if (failedLoginAttempts != null) {
            user.setFailedAttempt(null);
            repository.save(user);
        }
    }

    private void updateStatus(Long id, Status status) {
        Optional<Usuario> op = super.buscarPor(id);
        if (op.isPresent()) {
            updateStatus(op.get(), status);
        } else {
            throw new UsuarioNotFoundException("O ID informado é inválido!");
        }
    }

    private void updateStatus(Usuario usuario, Status status) {
        if (Status.ATIVO.equals(status)) {
            usuario.ativar();
        } else if (Status.BLOQUEADO.equals(status)) {
            usuario.bloquear();
        }
        repository.save(usuario);
    }

    public void bloquear(Long id) {
        updateStatus(id, Status.BLOQUEADO);
    }

    public void bloquear(Usuario usuario) {
        updateStatus(usuario, Status.BLOQUEADO);
    }

    public void ativar(Long id) {
        updateStatus(id, Status.ATIVO);
    }

    public void ativar(Usuario usuario) {
        updateStatus(usuario, Status.ATIVO);
    }

    @Override
    public Page<Usuario> listar(String nome, Pageable paginacao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
