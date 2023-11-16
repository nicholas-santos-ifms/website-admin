/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_empresa;

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
@RequestMapping("/api/empresa")
@Profile(value = {"prod", "dev", "test"})
public class EmpresaController extends AbstractBasicController<
        Empresa, EmpresaDto, EmpresaForm, EmpresaRepository, EmpresaService, Long> {

    @Autowired
    @Override
    public void setService(EmpresaService service) {
        super.service = service;
        super.setMapper(EmpresaMapper.INSTANCE);
    }

    @Override
    protected URI createUri(Empresa entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/api/empresa/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }

}
