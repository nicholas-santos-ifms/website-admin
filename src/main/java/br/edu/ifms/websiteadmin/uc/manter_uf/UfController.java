/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_uf;

import br.edu.ifms.arch.v010.controller.AbstractBasicController;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author 1513003
 */
@RestController
@RequestMapping("/api/uf")
@Profile(value = {"prod", "dev", "test"})
public class UfController extends AbstractBasicController<
        Uf, UfDto, UfForm, UfRepository, UfService, Long> {

    @Autowired
    @Override
    public void setService(UfService service) {
        super.service = service;
        super.setMapper(UfMapper.INSTANCE);
    }

    @Override
    protected URI createUri(Uf entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/uf/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}
