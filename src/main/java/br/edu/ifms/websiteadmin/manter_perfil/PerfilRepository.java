package br.edu.ifms.websiteadmin.manter_perfil;

import br.edu.ifms.arch.v010.repository.IArchRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author santos
 */
@Repository
public interface PerfilRepository extends IArchRepository<Perfil, Long> {
    
    public List<Perfil> findAllByIdBetween(Long start, Long end);
    
}
