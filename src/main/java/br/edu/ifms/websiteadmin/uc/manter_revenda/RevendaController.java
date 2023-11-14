/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_revenda;

import br.edu.ifms.websiteadmin.uc.manter_produto.*;
import br.edu.ifms.arch.v010.controller.AbstractSimpleController;
import jakarta.transaction.Transactional;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author 1513003
 */
@RestController
@RequestMapping("/api/revenda")
@Profile(value = {"prod", "dev", "test"})
public class RevendaController extends AbstractSimpleController<
        Revenda, Long, RevendaDto, RevendaForm, RevendaRepository, RevendaService> {

    @Autowired
    @Override
    public void setService(RevendaService service) {
        super.service = service;
        super.setMapper(RevendaMapper.INSTANCE);
    }

    @Override
    protected URI createUri(Revenda entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/revenda/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

    @GetMapping
    public ResponseEntity<Page<RevendaDto>> listar(
            @RequestParam(required = true) Long empresaId,
            @RequestParam(required = false) String nome,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        super.validate();

        Page<Revenda> page = service.listar(nome, empresaId, paginacao);
        return ResponseEntity.ok(mapper.toDtoPage(page));
    }

    @GetMapping("/page-not-used")
    @Override
    public ResponseEntity<Page<RevendaDto>> listar(Pageable paginacao) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list-not-used")
    @Override
    public List<RevendaDto> listar() {
        return null;
    }

    @GetMapping("/list/{empresaId}")
    public List<RevendaDto> listar(@PathVariable(required = true) Long empresaId) {
        this.validate();
        var entityList = service.listar(empresaId);
        return mapper.toDtoList(entityList);
    }

    @GetMapping("/not-used/{id}")
    @Override
    public ResponseEntity<RevendaDto> visualizar(@PathVariable Long id) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{empresaId}/{id}")
    public ResponseEntity<RevendaDto> visualizar(
            @PathVariable Long empresaId,
            @PathVariable Long id) {
        this.validate();
        return service.buscarPor(empresaId, id)
                .map(entity -> ResponseEntity
                .ok(mapper.toDto(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Transactional
    @Override
    public ResponseEntity<RevendaDto> cadastrar(RevendaForm form, UriComponentsBuilder uriBuilder) {
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @Transactional
    @Override
    public ResponseEntity<RevendaDto> atualizar(Long id, RevendaForm form) {
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    @Override
    public ResponseEntity<?> remover(Long id) {
        return ResponseEntity.notFound().build();
    }

}
