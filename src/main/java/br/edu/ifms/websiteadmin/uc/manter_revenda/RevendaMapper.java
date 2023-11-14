/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_revenda;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ISimpleMapper;
import br.edu.ifms.websiteadmin.uc.manter_cidade.CidadeMapper;
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
        config = BaseObjectMapper.class, 
        uses = {
            CidadeMapper.class
        }
)
public interface RevendaMapper
        extends ISimpleMapper<Revenda, RevendaDto, RevendaForm> {

    public static final RevendaMapper INSTANCE = Mappers.getMapper(RevendaMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Mapping(target = "empresa", ignore = true)
    @Override
    public Revenda formToEntity(RevendaForm dto);

    @Mapping(target = "empresa", ignore = true)
    @Override
    public Revenda dtoToEntity(RevendaDto dto);
    

    @InheritConfiguration(name = "update")
    @Mapping(target = "empresa", ignore = true)
    @Override
    public Revenda update(
            RevendaForm dto,
            @MappingTarget Revenda entity);

}
