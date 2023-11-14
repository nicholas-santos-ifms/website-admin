/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_pais;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ISimpleMapper;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author 1513003
 */
@Mapper(
        config = BaseObjectMapper.class
)
public interface PaisMapper
        extends ISimpleMapper<Pais, PaisDto, PaisForm>  {

    public static final PaisMapper INSTANCE = Mappers
            .getMapper(PaisMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Override
    public Pais formToEntity(PaisForm dto);

    @InheritConfiguration(name = "update")
    @Override
    public Pais update(PaisForm dto, @MappingTarget Pais entity);
    
}
