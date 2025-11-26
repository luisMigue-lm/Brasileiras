package com.projeto.Brasileiras.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projeto.Brasileiras.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class ClienteRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Cliente cliente) {
        em.persist(cliente);

    }

    public List<Cliente> findAll() {
        String jpql = "SELECT c FROM Cliente c";
        return em.createQuery(jpql, Cliente.class).getResultList();
    }

    public Cliente findById(Long id) {
        return em.find(Cliente.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        Cliente clienteDelete = em.find(Cliente.class, id);

        if (clienteDelete != null) {
            em.remove(clienteDelete);
        }
    }

    @Transactional
    public void update(Cliente cliente) {
        em.merge(cliente);
    }

    public Cliente buscarPorEmailESenha(String email, String senha) {

        try {
            String sql = "SELECT * FROM pessoas WHERE email = :email AND senha = :senha";

            Query query = em.createNativeQuery(sql, Cliente.class);
            query.setParameter("email", email);
            query.setParameter("senha", senha);
            Cliente cliente = (Cliente) query.getSingleResult();
            return cliente;
        } catch (Exception e) {
            return null;
        }
    }

}