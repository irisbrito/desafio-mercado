package br.com.zup.desafio.models;

import java.util.List;

public class Compra {
    private Cliente cliente;
    private List<Produto> listaDeProdutos;

    public Compra() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Produto> getListaDeProdutos() {
        return listaDeProdutos;
    }

    public void setListaDeProdutos(List<Produto> listaDeProdutos) {
        this.listaDeProdutos = listaDeProdutos;
    }
}
