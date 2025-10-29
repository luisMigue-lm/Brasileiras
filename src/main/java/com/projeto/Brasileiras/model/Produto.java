package com.projeto.Brasileiras.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
public class Produto {
    
    private Long id;

    private String nome;
    
    private String quantidade;

    private String categoria;

    private String preco;

    private String produtor;

    private LocalDate dtValidade;

    private String caminhoFoto;

    public Produto(Long id, String nome, String quantidade, String categoria, String preco, String produtor,
            LocalDate dtValidade, String caminhoFoto) {
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.categoria = categoria;
        this.preco = preco;
        this.produtor = produtor;
        this.dtValidade = dtValidade;
        this.caminhoFoto = caminhoFoto;
    }

    public Produto() {}
}
