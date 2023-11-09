/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 *
 * @author nicho
 * @param <T>
 * @param <K>
 */
public interface IArchRepository<T, K> 
        extends JpaRepository<T, K>,
        JpaSpecificationExecutor<T>{
    
}
