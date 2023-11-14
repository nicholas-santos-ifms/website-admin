/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_redessociais;

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
public interface RedeSocialMapper
        extends ISimpleMapper<RedeSocial, RedeSocialDto, RedeSocialForm> {

    public static final RedeSocialMapper INSTANCE = Mappers.getMapper(RedeSocialMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Mapping(target = "empresa", ignore = true)
    @Override
    public RedeSocial formToEntity(RedeSocialForm dto);

    @Mapping(target = "empresa", ignore = true)
    @Override
    public RedeSocial dtoToEntity(RedeSocialDto dto);

    @InheritConfiguration(name = "update")
    @Mapping(target = "empresa", ignore = true)
    @Override
    public RedeSocial update(
            RedeSocialForm dto,
            @MappingTarget RedeSocial entity);

}
