package br.com.zup.desafio.DTOs;

public class ProdutoDTO {
    private String nome;
    private int quantidade;

    public ProdutoDTO(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public ProdutoDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
