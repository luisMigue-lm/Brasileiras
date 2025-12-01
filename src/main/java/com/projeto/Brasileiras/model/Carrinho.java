package com.projeto.Brasileiras.model;

public class Carrinho {

    private int quantidade;
    private Produto produto;

    public Carrinho(int quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Carrinho() {
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public double getSubtotal() {
        return quantidade * produto.getPreco();
    }

}
