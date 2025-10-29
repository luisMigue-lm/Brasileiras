package com.projeto.Brasileiras.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "pedidos")
@Data
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_pedido")
    private Long numPedido;

    @Column(name = "cliente")
    private Cliente cliente;
    
    @Column(name = "endereco_entrega")
    private Endereco enderecoEntrega;

    @Column(name = "produtos_comprados")
    private List<Produto> produtos;

    @Column(name = "data_pedido")
    private LocalDate dtPedido;

    public Pedido(Long numPedido, Cliente cliente, Endereco enderecoEntrega, List<Produto> produtos,
            LocalDate dtPedido) {
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
        this.produtos = produtos;
        this.dtPedido = dtPedido;
    }

    public Pedido() {}

}
