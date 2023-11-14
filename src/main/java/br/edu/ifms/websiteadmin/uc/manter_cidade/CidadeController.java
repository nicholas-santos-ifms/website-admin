/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_cidade;

import br.edu.ifms.arch.v010.controller.AbstractSimpleController;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author 1513003
 */
@RestController
@RequestMapping("/api/cidade")
@Profile(value = {"prod", "dev", "test"})
public class CidadeController extends AbstractSimpleController<
        Cidade, Long, CidadeDto, CidadeForm, CidadeRepository, CidadeService> {

    @Autowired
    @Override
    public void setService(CidadeService service) {
        super.service = service;
        super.setMapper(CidadeMapper.INSTANCE);
    }

    @Override
    protected URI createUri(Cidade entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/cidade/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }
    
    @GetMapping
    public ResponseEntity<Page<CidadeDto>> listar(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) Long ufId,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        super.validate();
        
        Page<Cidade> page = service.listar(nome, ufId, paginacao);
        return ResponseEntity.ok(mapper.toDtoPage(page));
    }
    
    @GetMapping("/page-not-used")
    @Override
    public ResponseEntity<Page<CidadeDto>> listar(Pageable paginacao) {
        return ResponseEntity.notFound().build();
    }

}
