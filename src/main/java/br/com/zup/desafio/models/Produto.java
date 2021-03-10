package br.com.zup.desafio.models;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Produto {

    @NotEmpty(message = "Nome do produto não pode ficar vazio")
    @NotNull(message = "O nome do produto é um campo obrigatório")
    private String nome;

    @NotEmpty(message = "O preço não pode ficar vazio")
    @NotNull(message = "Preço é um campo obrigatório")
    private Double preco;

    @NotEmpty(message = "Quantidade não pode ficar vazio")
    @NotNull(message = "Quantidade é um campo obrigatório")
    private int quantidade;

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
