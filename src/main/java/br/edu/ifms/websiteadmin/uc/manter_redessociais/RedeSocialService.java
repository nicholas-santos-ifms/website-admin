/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.websiteadmin.uc.manter_redessociais;

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
public class RedeSocialService 
    extends AbstractService<RedeSocial, Long, RedeSocialForm, RedeSocialRepository>{

    @Autowired
    @Override
    public void setRepository(RedeSocialRepository repository) {
        this.repository = repository;
        super.setMapper(RedeSocialMapper.INSTANCE);
    }

    public Page<RedeSocial> listar(String nome, Long empresaId, Pageable paginacao) {
        List<Specification<RedeSocial>> l = new ArrayList();

        if (empresaId == null || empresaId <= 0) {
            throw new RedeSocialNotFoundException("Rede Social inexistente");
        }

        Specification<RedeSocial> spec = (root, query, criteriaBuilder)
                -> criteriaBuilder.equal(
                        root.get("empresa").get("id"),
                        empresaId);
        l.add(spec);

        if (StringUtils.hasText(nome)) {
            Specification<RedeSocial> specification = (root, query, criteriaBuilder)
                    -> criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("nome")),
                            "%" + nome.toUpperCase() + "%");
            l.add(specification);
        }

        if (l.isEmpty()) {
            return repository.findAll(paginacao);
        }

        Specification<RedeSocial> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result, paginacao);
    }

    public Optional<RedeSocial> buscarPor(Long empresaId, Long id) {
        return repository.findByEmpresaIdAndId(empresaId, id);
    }

    public List<RedeSocial> listar(Long empresaId) {
        return repository.findByEmpresaId(empresaId);
    }
    
}
