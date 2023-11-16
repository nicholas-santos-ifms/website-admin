/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_produto;

import br.edu.ifms.arch.v010.controller.AbstractSimpleController;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author 1513003
 */
@RestController
@RequestMapping("/api/produto")
@Profile(value = {"prod", "dev", "test"})
public class ProdutoController extends AbstractSimpleController<
        Produto, Long, ProdutoDto, ProdutoForm, ProdutoRepository, ProdutoService> {

    @Autowired
    @Override
    public void setService(ProdutoService service) {
        super.service = service;
        super.setMapper(ProdutoMapper.INSTANCE);
    }

    @Override
    protected URI createUri(Produto entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/produto/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

    @GetMapping
    public ResponseEntity<Page<ProdutoDto>> listar(
            @RequestParam(required = true) Long empresaId,
            @RequestParam(required = false) String nome,
            @PageableDefault(sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable paginacao) {
        super.validate();

        Page<Produto> page = service.listar(nome, empresaId, paginacao);
        return ResponseEntity.ok(mapper.toDtoPage(page));
    }

    @GetMapping("/page-not-used")
    @Override
    public ResponseEntity<Page<ProdutoDto>> listar(Pageable paginacao) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list-not-used")
    @Override
    public List<ProdutoDto> listar() {
        return null;
    }

    @GetMapping("/list/{empresaId}")
    public List<ProdutoDto> listar(@PathVariable(required = true) Long empresaId) {
        this.validate();
        var entityList = service.listar(empresaId);
        return mapper.toDtoList(entityList);
    }

    @GetMapping("/not-used/{id}")
    @Override
    public ResponseEntity<ProdutoDto> visualizar(@PathVariable Long id) {
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{empresaId}/{id}")
    public ResponseEntity<ProdutoDto> visualizar(
            @PathVariable Long empresaId,
            @PathVariable Long id) {
        this.validate();
        return service.buscarPor(empresaId, id)
                .map(entity -> ResponseEntity
                .ok(mapper.toDto(entity)))
                .orElse(ResponseEntity.notFound().build());
    }

}
