package br.com.zup.desafio.DTOs;

import br.com.zup.desafio.models.Cliente;
import br.com.zup.desafio.models.Compra;
import br.com.zup.desafio.models.Produto;

import java.util.List;

public class CompraDTO {
    private String cpf;
    private List<Produto> produtos;


    public CompraDTO(String cpf, List<Produto> produtos) {
        this.cpf = cpf;
        this.produtos = produtos;
    }

    public CompraDTO() {
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Compra converterCompraDTO(Cliente cliente, List<Produto> produtos){
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setListaDeProdutos(produtos);
        return compra;
    }
}
