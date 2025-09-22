package com.projeto.Brasileiras.model;

import java.time.LocalDate;
import java.util.List;

//import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "clientes")
@DiscriminatorValue("CLIENTE")
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Pessoa{

    //@Column(name = "formas_pagamento")
    //private List<FormaPagamento> formasPagamento;

    //@Column(name = "pedidos")
    //private List<Pedido> pedidos;

    public Cliente(Long id, String nome, String telefone, String email, String senha, String cpf,
            LocalDate dtNascimento, Endereco endereco, String enderecoFoto, List<FormaPagamento> formasPagamento, List<Pedido> pedidos) {
        super(id, nome, telefone, email, senha, cpf, dtNascimento, endereco, enderecoFoto);
        //this.formasPagamento = formasPagamento;
        //this.pedidos = pedidos;
    }

    public Cliente(List<FormaPagamento> formasPagamento, List<Pedido> pedidos) {
        //this.formasPagamento = formasPagamento;
       // this.pedidos = pedidos;
    }

    public Cliente() {}
}
