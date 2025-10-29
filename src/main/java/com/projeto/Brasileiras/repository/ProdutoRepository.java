package com.projeto.Brasileiras.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projeto.Brasileiras.model.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Produto produto) {
        em.persist(produto);
    }

    public List<Produto> findAll() {
        String jpql = "SELECT p FROM Produto";
        return em.createQuery(jpql, Produto.class).getResultList();
    }

    public Produto findById(Long id) {
        return em.find(Produto.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        Produto produtoDelete = em.find(Produto.class, id);

        if (produtoDelete != null) {
            em.remove(produtoDelete);
        }
    }

    @Transactional
    public void update(Produto produto) {
        em.merge(produto);
    }
}
