/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010.controller;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author nicho
 * @param <T>
 * @param <K>
 * @param <DTO>
 * @param <LEANDTO>
 * @param <F>
 */
public interface ILeanController<T, K, DTO, LEANDTO, F>
    extends ISimpleController<T, K, DTO, F> {

    public ResponseEntity<Page<LEANDTO>> listarLean(Pageable paginacao);
    
    public List<LEANDTO> listarLean();
}
