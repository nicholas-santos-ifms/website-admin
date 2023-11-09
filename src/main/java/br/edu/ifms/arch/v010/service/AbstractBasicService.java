/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifms.arch.v010.service;


import br.edu.ifms.arch.v010.repository.IArchRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

/**
 *
 * @author santos
 * @param <T>
 * @param <K>
 * @param <F>
 * @param <R>
 */
public abstract class AbstractBasicService<
            T, K, F, R extends IArchRepository<T, K>>
        extends AbstractService<T, K, F, R>
        implements IBasicService<T, K, F, R> {
    
    @Override
    public Page<T> listar(String nome, Pageable paginacao) {
        List<Specification<T>> l = new ArrayList();
        
        if (StringUtils.hasText(nome)) {
            Specification<T> spec = (root, query, criteriaBuilder)
                    -> criteriaBuilder.like(
                            criteriaBuilder.upper(root.get("nome")),
                            "%" + nome.toUpperCase() + "%");
            l.add(spec);
        }

        if (l.isEmpty()) {
            return repository.findAll(paginacao);
        }

        Specification<T> result = l.get(0);
        for (int i = 1; i < l.size(); i++) {
            result = Specification.where(result).and(l.get(i));
        }

        return repository.findAll(result, paginacao);
    }
}
