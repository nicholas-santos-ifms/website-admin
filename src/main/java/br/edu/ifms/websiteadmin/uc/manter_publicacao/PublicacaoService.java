/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_publicacao;

import br.edu.ifms.arch.v010.service.AbstractService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author 1513003
 */
@Service
public class PublicacaoService
        extends AbstractService<Publicacao, Long, PublicacaoForm, PublicacaoRepository> {

    @Autowired
    @Override
    public void setRepository(PublicacaoRepository repository) {
        this.repository = repository;
        super.setMapper(PublicacaoMapper.INSTANCE);
    }

    public Page<Publicacao> listar(String nome, Long empresaId, Pageable paginacao) {
        List<Specification<Publicacao>> l = new ArrayList();

        if (empresaId == null || empresaId <= 0) {
            throw new PublicacaoNotFoundException("Publicação inexistente");
        }

        Specification<Publicacao> spec = (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(
                        root.get("empresa").get("id"),
                        empresaId);
        l.add(spec);

        if (StringUtils.hasText(nome)) {
            Specification<Publicacao> specification = (root, query, criteriaBuilder)
                    -> criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("nome")),
                            "%" + nome.toUpperCase() + "%");
            l.add(specification);
        }

        if (l.isEmpty()) {
            return repository.findAll(paginacao);
        }

        Specification<Publicacao> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result, paginacao);
    }

    public Optional<Publicacao> buscarPor(Long empresaId, Long id) {
        return repository.findByEmpresaIdAndId(empresaId, id);
    }

    public List<Publicacao> listar(Long empresaId) {
        return repository.findByEmpresaId(empresaId);
    }

}
