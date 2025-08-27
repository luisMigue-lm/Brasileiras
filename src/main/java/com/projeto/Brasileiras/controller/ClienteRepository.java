package com.projeto.Brasileiras.controller;

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
        String sql = "INSERT INTO pessoas (nome ,email, telefone, dt_nascimento, senha, cpf) VALUES (:nome, :email, :telefone, :dtNascimento, :senha, :cpf)";
        
        Query query = em.createNativeQuery(sql);
        query.setParameter("nome", cliente.getNome());
        query.setParameter("telefone", cliente.getTelefone());
        query.setParameter("email", cliente.getEmail());
        query.setParameter("senha", cliente.getSenha());
        query.setParameter("cpf", cliente.getCpf());
        query.setParameter("dtNascimento", cliente.getDtNascimento());
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