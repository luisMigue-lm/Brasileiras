package com.projeto.Brasileiras.Controller;

import org.springframework.stereotype.Repository;

import com.projeto.Brasileiras.model.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class BrasileirasRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Cliente cliente) {
        String sql = "INSERT INTO brasileirasdb (nome ,email, telefone, dataNascimento, senha) VALUES (:nome, :email, :telefone, :dataNascimento, :senha)";

        Query query = em.createNativeQuery(sql);
        query.setParameter("nome", cliente.getNome());
        query.setParameter("email", cliente.getEmail());
        query.setParameter("telefone", cliente.getTelefone());
        query.setParameter("dataNascimento", cliente.getDataNascimento());
        query.setParameter("senha", cliente.getSenha());
        query.executeUpdate();
    }

    public Cliente EmaileSenha(String email, String senha) {
        String sql = "SELECT * FROM cliente WHERE email = :email AND senha = :senha";

        Query query = em.createNativeQuery(sql, Cliente.class);
        query.setParameter("email", email);
        query.setParameter("senha", senha);
        Cliente cliente = (Cliente) query.getSingleResult();
        return cliente;
    }

}