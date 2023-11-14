/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_cidade;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ISimpleMapper;
import br.edu.ifms.websiteadmin.uc.manter_uf.UfMapper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author 1513003
 */
@Mapper(
        config = BaseObjectMapper.class,
        uses = {
            UfMapper.class
        }
)
public interface CidadeMapper
        extends ISimpleMapper<Cidade, CidadeDto, CidadeForm> {

    public static final CidadeMapper INSTANCE = Mappers.getMapper(CidadeMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Override
    public Cidade formToEntity(CidadeForm dto);

    @InheritConfiguration(name = "update")
    @Override
    public Cidade update(
            CidadeForm dto,
            @MappingTarget Cidade entity);

}
