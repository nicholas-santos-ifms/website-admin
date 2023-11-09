package br.edu.ifms.websiteadmin.manter_arquivo;

import br.edu.ifms.arch.v010.repository.IArchRepository;
import org.springframework.stereotype.Repository;

/**
 * 
 *  @author santos
 * 
 */
@Repository
public abstract interface ArquivoRepository extends IArchRepository<Arquivo,Long> {
    
}
