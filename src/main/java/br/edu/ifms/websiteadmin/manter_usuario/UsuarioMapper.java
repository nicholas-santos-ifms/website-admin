/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_usuario;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ILeanMapper;
import br.edu.ifms.websiteadmin.manter_arquivo.ArquivoMapper;
import br.edu.ifms.websiteadmin.manter_perfil.PerfilMapper;
import br.edu.ifms.websiteadmin.types.Status;
import java.io.IOException;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 1513003
 */
@Mapper(
        config = BaseObjectMapper.class,
        uses = {
            ArquivoMapper.class,
            PerfilMapper.class
        }
)
public interface UsuarioMapper
        extends ILeanMapper<Usuario, UsuarioDto, UsuarioLeanDto, UsuarioForm> {

    public static final UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "cpf", expression = "java(dto.getCpf() != null ? dto.getCpf().replaceAll(\"[^\\\\d]+\", \"\") : null)")
    @Mapping(target = "tipoNotificacao", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "failedAttempt", ignore = true)
    @Mapping(target = "lockTime", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "lastFailedLoginTime", ignore = true)
    @Mapping(target = "foto", ignore = true)
    @Mapping(target = "perfis", ignore = true)
    public Usuario toEntity(UsuarioForm dto);

    @Override
    public default Usuario formToEntity(UsuarioForm dto) {
        if (dto.getPerfis() == null || dto.getPerfis().isEmpty()) {
            throw new UsuarioNotFoundException("A lista de perfis não pode ser vazia.");
        }

        var entity = toEntity(dto);
        entity.setAccountNonLocked(Boolean.TRUE);
        entity.setStatus(Status.BLOQUEADO);
        entity.setTipoNotificacao(TipoNotificacao.EMAIL);

        entity.setPerfis(PerfilMapper.INSTANCE.toEntityList(dto.getPerfis()));

        return entity;
    }

    default public Usuario formToEntityWithFile(
            UsuarioForm dto,
            MultipartFile fotoFile) throws IOException {
        var obj = formToEntity(dto);
        if (fotoFile != null) {
            var foto = ArquivoMapper.INSTANCE.fileToEntity(fotoFile);
            obj.setFoto(foto);
        }

        return obj;
    }

    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "failedAttempt", ignore = true)
    @Mapping(target = "lockTime", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "lastFailedLoginTime", ignore = true)
    @Override
    public Usuario dtoToEntity(UsuarioDto dto);

    @InheritConfiguration(name = "update")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "cpf", expression = "java(dto.getCpf() != null ? dto.getCpf().replaceAll(\"[^\\\\d]+\", \"\") : null)")
    @Mapping(target = "tipoNotificacao", ignore = true)
    @Mapping(target = "enabled", ignore = true)
    @Mapping(target = "failedAttempt", ignore = true)
    @Mapping(target = "lockTime", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "lastFailedLoginTime", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    @Mapping(target = "authorityNames", ignore = true)
    @Mapping(target = "foto", ignore = true)
    @Mapping(target = "perfis", ignore = true)
    public Usuario preUpdate(
            UsuarioForm dto,
            @MappingTarget Usuario entity);

    @Override
    public default Usuario update(
            UsuarioForm dto,
            @MappingTarget Usuario entity) {
        preUpdate(dto, entity);
        entity.setPerfis(PerfilMapper.INSTANCE.toEntityList(dto.getPerfis()));

        return entity;
    }

    default public Usuario updateWithFile(
            UsuarioForm dto,
            Usuario entity,
            MultipartFile file) throws IOException {
        update(dto, entity);
        if (file != null) {
            entity.setFoto(ArquivoMapper.INSTANCE.fileToEntity(file));
        }

        return entity;
    }

    /* Controle de mapeamento do movimento das sedes */
    @Mapping(target = "senha", ignore = true)
    @Mapping(target = "cpf", ignore = true)
    @Mapping(target = "tipoNotificacao", ignore = true)
    @Mapping(target = "perfis", ignore = true)
    @Mapping(target = "failedAttempt", ignore = true)
    @Mapping(target = "lockTime", ignore = true)
    @Mapping(target = "accountNonLocked", ignore = true)
    @Mapping(target = "lastFailedLoginTime", ignore = true)
    @Override
    public Usuario leanDtoToEntity(UsuarioLeanDto dto);

}
