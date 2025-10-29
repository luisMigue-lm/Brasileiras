package com.projeto.Brasileiras.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.projeto.Brasileiras.model.Funcionario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class FuncionarioRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Funcionario funcionario) {
        em.persist(funcionario);
    }

    public List<Funcionario> findAll() {
        String jpql = "SELECT f FROM Funcionario";
        return em.createQuery(jpql, Funcionario.class).getResultList();
    }

    public Funcionario findById(Long id) {
        return em.find(Funcionario.class, id);
    }

    @Transactional
    public void deleteById(Long id) {
        Funcionario funcionarioDelete = em.find(Funcionario.class, id);

        if (funcionarioDelete != null) {
            em.remove(funcionarioDelete);
        }
    }

    @Transactional
    public void update(Funcionario funcionario) {
        em.merge(funcionario);
    }
}
