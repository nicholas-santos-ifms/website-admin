/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.repository.IArchRepository;
import br.edu.ifms.websiteadmin.types.Status;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author santos
 */
public interface UsuarioRepository extends IArchRepository<Usuario, Long> {

    @Query(value = """
                   SELECT u 
                     FROM Usuario u 
                     LEFT JOIN FETCH u.perfis 
                    WHERE LOWER(u.email) LIKE LOWER(?1)
                      AND TRIM(u.status) LIKE 'ATIVO'
                      AND u.enabled = true
                   """,
            countName = """
                   SELECT COUNT(u)
                     FROM Usuario u
                    WHERE LOWER(u.email) LIKE LOWER(?1)
                      AND TRIM(u.status) LIKE 'ATIVO'
                      AND u.enabled = true
                   """)
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findByStatusAndEnabled(Status status, Boolean enabled);

    @Query(value = """
                   SELECT u 
                     FROM Usuario u 
                     LEFT JOIN FETCH u.perfis 
                    WHERE u.id = ?1 
                   """,
            countName = "SELECT count(u) FROM Usuario u WHERE u.id = ?1 ")
    Optional<Usuario> findDetailUsuarioById(Long id);

    @Query(value = """
                   SELECT u 
                     FROM Usuario u 
                     LEFT JOIN FETCH u.perfis 
                    WHERE u.id = ?1 
                      AND u.status = 'ATIVO'
                      AND u.enabled = true
                   """,
            countName = "SELECT count(u) FROM Usuario u WHERE u.id = ?1 ")
    Optional<Usuario> findUsuarioEnabledById(Long id);

    @Query(value = """
                   UPDATE Usuario u 
                      SET u.failedAttempt = ?1,
                          u.lastFailedLoginTime = ?2
                   WHERE u.email = ?3
                     AND u.enabled = true
                     AND u.status = 'ATIVO'
                   """)
    @Modifying
    int updateFailureAttempt(
            Integer failedAttempt,
            Long lastFailedLoginTime,
            String email);

    @Query(value = """
                   UPDATE Usuario u 
                      SET u.senha = ?1
                   WHERE u.email = ?2
                     AND u.enabled = true
                     AND u.status = 'ATIVO'
                   """)
    @Modifying
    int updateSenha(String senha, String email);

    Optional<Usuario> findByEmailAndStatusAndEnabled(String email, Status status, boolean enabled);

    Optional<Usuario> findByEmailOrCpf(String email, String cpf);

    @Transactional
    @Modifying
    @Query("update Usuario u set "
            + "u.senha = ?2 "
            + "where u.email= ?1 "
            + "  and u.status = 'ATIVO' "
            + "  and u.enabled = true ")
    int setSenhaFor(String email, String senha);

}
