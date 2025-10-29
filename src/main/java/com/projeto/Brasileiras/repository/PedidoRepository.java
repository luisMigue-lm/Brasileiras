package com.projeto.Brasileiras.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projeto.Brasileiras.model.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class PedidoRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Pedido pedido) {
        em.persist(pedido);
    }

    public List<Pedido> findAll() {
        String jpql = "SELECT p FROM Pedido";
        return em.createQuery(jpql, Pedido.class).getResultList();
    }

    public Pedido findById(Long id) {
        return em.find(Pedido.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        Pedido pedidoDelete = em.find(Pedido.class, id);

        if (pedidoDelete != null) {
            em.remove(pedidoDelete);
        }
    }

    @Transactional
    public void update(Pedido pedido) {
        em.merge(pedido);
    }
}
