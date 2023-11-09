/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_produto;

import br.edu.ifms.arch.v010.service.AbstractBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author 1513003
 */
@Service
public class ProdutoService 
    extends AbstractBasicService<Produto, Long, ProdutoForm, ProdutoRepository>{

    @Autowired
    @Override
    public void setRepository(ProdutoRepository repository) {
        this.repository = repository;
        super.setMapper(ProdutoMapper.INSTANCE);
    }
    
}
