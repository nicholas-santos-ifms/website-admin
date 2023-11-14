/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_empresa;

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
public interface EmpresaMapper
        extends ISimpleMapper<Empresa, EmpresaDto, EmpresaForm> {

    public static final EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Override
    public Empresa formToEntity(EmpresaForm dto);

    @InheritConfiguration(name = "update")
    @Override
    public Empresa update(
            EmpresaForm dto,
            @MappingTarget Empresa entity);

}
