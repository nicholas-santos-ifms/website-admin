package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.BaseObject;
import br.edu.ifms.websiteadmin.manter_arquivo.Arquivo;
import br.edu.ifms.websiteadmin.manter_perfil.Perfil;
import br.edu.ifms.websiteadmin.types.Status;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//@EntityListeners(AuditoriaListener.class)
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@SequenceGenerator(
        sequenceName = "usuario_sequence",
        name = "baseObjectSequence",
        allocationSize = 1)
public class Usuario extends BaseObject implements UserDetails, Serializable {

    /**
     * Atributo utilizado para entrar em contato com o usu√°rio e se autenticar
     * no sistema
     */
    @EqualsAndHashCode.Include
    @Column(nullable = false)
    private String email;

    private String senha;

    /**
     * Atributo utilizado para registrar status do usu√°rio.
     *
     * A situaÁ„o pode ser:<br/>
     * <ul>
     * <li>ATIVO</li>
     * <li>INATIVO</li>
     * <li>BLOQUADO</i>
     * </ul>
     */
    @Column(nullable = false, columnDefinition = "varchar(255) default 'BLOQUEADO'")
    @Enumerated(EnumType.STRING)
    private Status status;

//    @Column(nullable = false, unique = true, length = 11)
//    @EqualsAndHashCode.Include
    private String cpf;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'EMAIL'")
    @Enumerated(EnumType.STRING)
    private TipoNotificacao tipoNotificacao;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'MASCULINO'")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    private String telefone;

    @Column(columnDefinition = "boolean default false")
    private boolean enabled;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foto_id", referencedColumnName = "id")
    private Arquivo foto;

    @ManyToMany(
            targetEntity = Perfil.class,
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "usuario_perfis",
            joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "perfis_id", referencedColumnName = "id"))
    private List<Perfil> perfis;

    @Column(columnDefinition = "integer default 0")
    private Integer failedAttempt;

    private LocalDateTime lockTime;

    @Column(columnDefinition = "boolean default true")
    private Boolean accountNonLocked;

    private Long lastFailedLoginTime;

    public void ativar() {
        this.status = Status.ATIVO;
        this.enabled = Boolean.TRUE;
        this.failedAttempt = null;
    }

    public void bloquear() {
        this.status = Status.BLOQUEADO;
        this.enabled = Boolean.FALSE;
    }

    public Boolean issetFoto() {
        return this.foto != null;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.perfis;
    }

    public List<String> getAuthorityNames() {
        List<String> list = this.perfis
                .stream()
                .map(perfil -> perfil.getAuthority())
                .collect(Collectors.toList());

        return list;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public String toString() {
        return super.getNome();
    }

}
