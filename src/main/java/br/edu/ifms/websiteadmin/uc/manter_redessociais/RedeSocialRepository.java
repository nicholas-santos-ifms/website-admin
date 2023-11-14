/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_redessociais;

import br.edu.ifms.arch.v010.repository.IArchRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 1513003
 */
public interface RedeSocialRepository extends IArchRepository<RedeSocial, Long> {

    Optional<RedeSocial> findByEmpresaIdAndId(Long empresaId, Long id);

    List<RedeSocial> findByEmpresaId(Long empresaId);
}
