/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_produto;

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
public interface ProdutoMapper
        extends ISimpleMapper<Produto, ProdutoDto, ProdutoForm> {

    public static final ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Override
    public Produto formToEntity(ProdutoForm dto);

    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Override
    public Produto dtoToEntity(ProdutoDto dto);

    @InheritConfiguration(name = "update")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", expression = "java(java.time.LocalDateTime.now())")
    @Override
    public Produto update(
            ProdutoForm dto,
            @MappingTarget Produto entity);

}
