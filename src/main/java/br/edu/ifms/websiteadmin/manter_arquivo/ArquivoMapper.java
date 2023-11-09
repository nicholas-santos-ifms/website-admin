/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_arquivo;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import br.edu.ifms.arch.v010.ISimpleMapper;
import java.io.IOException;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author 1513003
 */
@Mapper(config = BaseObjectMapper.class)
public interface ArquivoMapper
        extends ISimpleMapper<Arquivo, ArquivoDto, ArquivoForm> {

    public static final ArquivoMapper INSTANCE = Mappers.getMapper(ArquivoMapper.class);

    @InheritConfiguration(name = "toEntity")
    @Override
    public Arquivo formToEntity(ArquivoForm dto);

    @InheritConfiguration(name = "update")
    @Override
    public Arquivo update(ArquivoForm dto, @MappingTarget Arquivo entity);
    
    public Arquivo update(
            ArquivoDto dto,
            @MappingTarget Arquivo entity);

    public default Arquivo update(
            MultipartFile file,
            Arquivo entity) throws IOException {
        entity.setNome(file.getOriginalFilename());
        entity.setTipo(file.getContentType());
        entity.setData(file.getBytes());
        return entity;
    }
    
    public default String extractDocumentType(MultipartFile file) {
        return file
                .getOriginalFilename()
                .substring(0, file
                        .getOriginalFilename()
                        .lastIndexOf("."));
    }

    public default Arquivo fileToEntity(MultipartFile file) throws IOException {
        return Arquivo.builder()
                .nome(file.getOriginalFilename())
                .tipo(file.getContentType())
                .data(file.getBytes())
                .build();
    }
    
}
