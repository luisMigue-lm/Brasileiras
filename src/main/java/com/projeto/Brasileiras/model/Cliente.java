package com.projeto.Brasileiras.model;

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
    

    //private List<FormaPagamento> formasPagamento;

    //private List<Pedido> pedidos;
}
