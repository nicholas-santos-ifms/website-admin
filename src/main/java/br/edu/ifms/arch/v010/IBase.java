/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.arch.v010;

import java.time.LocalDateTime;

/**
 *
 * @author 1513003
 */
public interface IBase {
    
    public void setId(Long id);
    public Long getId();
    public void setNome(String nome);
    public String getNome();
    public void setCreatedAt(LocalDateTime value);
    public LocalDateTime getCreatedAt();
    
}
