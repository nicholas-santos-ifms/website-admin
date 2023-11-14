/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_redessociais;

import br.edu.ifms.arch.v010.controller.AbstractBasicController;
import br.edu.ifms.arch.v010.controller.AbstractSimpleController;
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
@RequestMapping("/api/rede-social")
@Profile(value = {"prod", "dev", "test"})
public class RedeSocialController extends AbstractSimpleController<
        RedeSocial, Long, RedeSocialDto, RedeSocialForm, RedeSocialRepository, RedeSocialService> {

    @Autowired
    @Override
    public void setService(RedeSocialService service) {
        super.service = service;
        super.setMapper(RedeSocialMapper.INSTANCE);
    }

    @Override
    protected URI createUri(RedeSocial entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/rede-social/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}
