/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_publicacao;

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
public interface PublicacaoMapper
        extends ISimpleMapper<Publicacao, PublicacaoDto, PublicacaoForm> {

    public static final PublicacaoMapper INSTANCE = Mappers.getMapper(PublicacaoMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Mapping(target = "empresa", ignore = true)
    @Override
    public Publicacao formToEntity(PublicacaoForm dto);

    @Mapping(target = "empresa", ignore = true)
    @Override
    public Publicacao dtoToEntity(PublicacaoDto dto);
    

    @InheritConfiguration(name = "update")
    @Mapping(target = "empresa", ignore = true)
    @Override
    public Publicacao update(
            PublicacaoForm dto,
            @MappingTarget Publicacao entity);

}
