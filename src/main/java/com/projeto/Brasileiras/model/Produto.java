package com.projeto.Brasileiras.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "produtos")
@Data
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome",nullable = false)
    private String nome;
    
    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "preco")
    private double preco;

    @Column(name = "produtor")
    private String produtor;

    @Column(name = "dt_validade")
    private LocalDate dtValidade;

    @Column(name = "caminho_foto")
    private String caminhoFoto;

    public Produto(Long id, String nome, int quantidade, String categoria, double preco, String produtor,
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
