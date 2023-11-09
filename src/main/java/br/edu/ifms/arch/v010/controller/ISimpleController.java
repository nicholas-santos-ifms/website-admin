/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010.controller;

import jakarta.validation.Valid;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author nicho
 * @param <T>
 * @param <K>
 * @param <DTO>
 * @param <F>
 */
public interface ISimpleController<T, K, DTO, F> {

    ResponseEntity<Page<DTO>> listar(Pageable paginacao);

    List<DTO> listar();

    ResponseEntity<DTO> visualizar(@PathVariable K id);

    ResponseEntity<DTO> cadastrar(@RequestBody @Valid F form, UriComponentsBuilder uriBuilder);

    ResponseEntity<DTO> atualizar(@PathVariable K id, @RequestBody @Valid F form);

    ResponseEntity<?> remover(@PathVariable K id);
}
