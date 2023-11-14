/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.websiteadmin.uc.manter_pais;

import br.edu.ifms.arch.v010.controller.AbstractBasicController;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author santos
 */
@RestController
@RequestMapping("api/pais")
@Profile(value = {"prod", "dev", "test"})
public class PaisController extends AbstractBasicController
        <Pais, PaisDto, PaisForm, PaisRepository, PaisService, Long> {

    @Autowired
    @Override
    public void setService(PaisService service) {
        super.service = service;
        super.setMapper(PaisMapper.INSTANCE);
    }

    @Override
    public URI createUri(Pais entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/pais/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}
