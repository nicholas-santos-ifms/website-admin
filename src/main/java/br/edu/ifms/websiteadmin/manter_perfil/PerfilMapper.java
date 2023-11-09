/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_perfil;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ISimpleMapper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author 1513003
 */
@Mapper(
        config = BaseObjectMapper.class
)
public interface PerfilMapper
        extends ISimpleMapper<Perfil, PerfilDto, PerfilForm> {

    public static final PerfilMapper INSTANCE = Mappers.getMapper(PerfilMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Mapping(target = "usuarios", ignore = true)
    @Override
    public Perfil formToEntity(PerfilForm dto);

    @InheritConfiguration(name = "update")
    @Mapping(target = "usuarios", ignore = true)
    @Override
    public Perfil update(PerfilForm dto, @MappingTarget Perfil entity);

    @Mapping(target = "usuarios", ignore = true)
    @Override
    public Perfil dtoToEntity(PerfilDto dto);
    
}
