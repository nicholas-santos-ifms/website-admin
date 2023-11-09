package br.edu.ifms.websiteadmin.manter_arquivo;

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
 *
 */
@RestController
@Profile(value = {"prod", "dev", "test"})
@RequestMapping("/api/arquivo")
public class ArquivoController
        extends AbstractBasicController<Arquivo, ArquivoDto, ArquivoForm, ArquivoRepository, ArquivoService, Long> {

    @Autowired
    @Override
    public void setService(ArquivoService service) {
        super.service = service;
        super.setMapper(ArquivoMapper.INSTANCE);
    }

    @Override
    public URI createUri(Arquivo entity, UriComponentsBuilder uriBuilder) {
        return uriBuilder.path("/arquivo/{id}")
                .buildAndExpand(entity.getId())
                .toUri();
    }
}
