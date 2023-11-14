/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_cidade;

import br.edu.ifms.arch.v010.service.AbstractService;
import java.util.ArrayList;
import java.util.List;
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
public class CidadeService
        extends AbstractService<Cidade, Long, CidadeForm, CidadeRepository> {

    @Autowired
    @Override
    public void setRepository(CidadeRepository repository) {
        this.repository = repository;
        super.setMapper(CidadeMapper.INSTANCE);
    }

    /**
     * Listar cidades. Lista cidades por nome, por unidade federativa ou ambos.
     *
     * @param nome
     * @param ufId
     * @param paginacao
     * @return
     */
    public Page<Cidade> listar(String nome, Long ufId, Pageable paginacao) {
        List<Specification<Cidade>> l = new ArrayList();

        if (StringUtils.hasText(nome)) {
            Specification<Cidade> spec = (root, query, criteriaBuilder)
                    -> criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("nome")),
                            "%" + nome.toUpperCase() + "%");
            l.add(spec);
        }

        if (ufId != null && ufId > 0) {
            Specification<Cidade> spec = (root, query, criteriaBuilder)
                    -> criteriaBuilder.equal(
                            root.get("uf")
                                    .get("id"), ufId);
            l.add(spec);
        }

        if (l.isEmpty()) {
            return repository.findAll(paginacao);
        }

        Specification<Cidade> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result, paginacao);
    }

}
