/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_publicacao;

import br.edu.ifms.arch.v010.repository.IArchRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author 1513003
 */
public interface PublicacaoRepository extends IArchRepository<Publicacao, Long> {

    Optional<Publicacao> findByEmpresaIdAndId(Long empresaId, Long id);

    List<Publicacao> findByEmpresaId(Long empresaId);

}
