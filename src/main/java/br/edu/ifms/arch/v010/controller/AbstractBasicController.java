/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.v010.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import br.edu.ifms.arch.v010.repository.IArchRepository;
import br.edu.ifms.arch.v010.service.IBasicService;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author santos
 * @param <T>
 * @param <DTO>
 * @param <FORM>
 * @param <R>
 * @param <S>
 * @param <K>
 */
@Profile(value = {"prod", "test", "dev"})
public abstract class AbstractBasicController<
            T, DTO, FORM, 
            R extends IArchRepository<T, K>, 
            S extends IBasicService<T, K, FORM, R>, 
            K>
        extends AbstractSimpleController<T, K, DTO, FORM, R, S>
        implements IBasicController<DTO> {

    @GetMapping
    @Override
    public ResponseEntity<Page<DTO>> listar(
            @RequestParam(required = false) String nome,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        super.validate();
        
        Page<T> page = service.listar(nome, paginacao);
        return ResponseEntity.ok(mapper.toDtoPage(page));
    }
    
    @GetMapping("/page-not-used")
    @Override
    public ResponseEntity<Page<DTO>> listar(Pageable paginacao) {
        return ResponseEntity.notFound().build();
    }

}
