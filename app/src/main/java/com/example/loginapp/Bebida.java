package com.example.loginapp;

import java.io.Serializable;

public class Bebida implements Serializable {
    private String nome;
    private int quantidade;
    private double preco;

    public Bebida(String nome, int quantidade, double preco) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return nome + " - " + quantidade + " unidades - R$" + preco;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }
}
