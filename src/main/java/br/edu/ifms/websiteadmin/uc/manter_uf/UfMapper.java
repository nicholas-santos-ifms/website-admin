/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_uf;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ISimpleMapper;
import br.edu.ifms.websiteadmin.uc.manter_pais.PaisMapper;
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
            PaisMapper.class
        }
)
public interface UfMapper
        extends ISimpleMapper<Uf, UfDto, UfForm> {

    public static final UfMapper INSTANCE = Mappers.getMapper(UfMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Override
    public Uf formToEntity(UfForm dto);

    @InheritConfiguration(name = "update")
    @Override
    public Uf update(
            UfForm dto,
            @MappingTarget Uf entity);

}
