package br.edu.ifms.websiteadmin.manter_arquivo;

import br.edu.ifms.arch.v010.service.AbstractBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author santos
 *
 */
@Service
public class ArquivoService extends AbstractBasicService<Arquivo, Long, ArquivoForm, ArquivoRepository> {

    @Autowired
    @Override
    public void setRepository(ArquivoRepository repository) {
        super.repository = repository;
        super.setMapper(ArquivoMapper.INSTANCE);
    }

}
