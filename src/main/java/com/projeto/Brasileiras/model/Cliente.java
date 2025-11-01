package com.projeto.Brasileiras.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
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

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos;

    public Cliente(Long id, String nome, String telefone, String email, String senha, String cpf,
            LocalDate dtNascimento, String enderecoFoto, List<Endereco> enderecos, List<Pedido> pedidos) {
        super(id, nome, telefone, email, senha, cpf, dtNascimento, enderecoFoto);
        this.pedidos = pedidos;
        this.enderecos = enderecos;
    }

    public Cliente(List<Pedido> pedidos, List<Endereco> enderecos) {
        this.pedidos = pedidos;
        this.enderecos = enderecos;
    }

    public Cliente() {}
}
