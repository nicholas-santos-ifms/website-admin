/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Interface para Servicos. Interface utilizada para definir os métodos básicos para a
  implementação dos serviços básicos que serão disponibilizados
  para a aplicação cuja Classe de Negócio seja subclasse de
  <class>BaseObject</class>.
 * @param <K>
 * @param <F>
 * @param <R>
 * @param <T>   Classe de Negócio a ser implementada
 * @since 02/11/2022
 * @author nicho
 */
public interface IBasicService<T, K, F, R>
    extends IService<T, K, F, R> {
    
    /**
     * Listagem de dados. Este m�todo tem a finalidade de buscar uma lista de
     * dados da Classe de Neg�cio <T> de acordo com a descri��o do parâmetro
     * NOME e da PAGINACAO
     *
     * @since 11-02-2022
     * @param paginacao Objeto da classe <class>Pageable</class>
     * @param nome      Objeto da classe <class>String</class> a ser usado para filtragem por nome
     * @return Retorna um objeto da classe <class>Page<T></class>.
     */
    Page<T> listar(String nome, Pageable paginacao);
}
