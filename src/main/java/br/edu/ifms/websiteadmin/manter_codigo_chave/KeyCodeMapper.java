/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.manter_codigo_chave;

import br.edu.ifms.arch.v010.BaseObjectMapper;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author 1513003
 */
@Mapper(
        config = BaseObjectMapper.class
)
public interface KeyCodeMapper {
    
    public static final KeyCodeMapper INSTANCE = Mappers.getMapper(KeyCodeMapper.class);
    
    default KeyCode toEntity(KeyCodeForm dto) throws NoSuchAlgorithmException, InvalidKeyException {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return KeyCode.builder()
                .mail(dto.getEmail())
                .password(encoder.encode(dto.getSenha()))
                .code(KeyCode.generateCode(dto.getEmail()))
                .createdAt(LocalDateTime.now())
                .build();
    }
}
