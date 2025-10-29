package com.projeto.Brasileiras.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projeto.Brasileiras.model.Endereco;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class EnderecoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Endereco endereco) {
        em.persist(endereco);
    }

    public List<Endereco> findAll() {
        String jpql = "SELECT e FROM Endereco";
        return em.createQuery(jpql, Endereco.class).getResultList();
    }

    public Endereco findById(Long id) {
        return em.find(Endereco.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        Endereco enderecoDelete = em.find(Endereco.class, id);

        if (enderecoDelete != null) {
            em.remove(enderecoDelete);
        }
    }

    @Transactional
    public void update(Endereco endereco) {
        em.merge(endereco);
    }
}
