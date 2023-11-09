/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010.dto;

/**
 * Interface para Formulário para BaseObject. Interface utilizada para definir
 os métodos básicos para a implementação do padrão DTO para envio de dados
 para os serviços cuja Classe de Negócio seja uma subclasse de
 <class>BaseObject</class>.
 *
 * @author santos
 */
public interface IBaseForm {
    
    String getNome();
    void setNome(String value);
}
