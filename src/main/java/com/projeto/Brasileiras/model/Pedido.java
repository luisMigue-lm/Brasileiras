package com.projeto.Brasileiras.model;

import java.time.LocalDate;
import java.util.List;  

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "endereco_entrega_id")
    private Endereco enderecoEntrega;

    @ManyToMany
    @JoinTable(name = "pedido_produtos", joinColumns = @JoinColumn(name = "pedido_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
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
