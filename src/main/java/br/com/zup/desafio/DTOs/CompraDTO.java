package br.com.zup.desafio.DTOs;

import br.com.zup.desafio.models.Cliente;
import br.com.zup.desafio.models.Compra;
import br.com.zup.desafio.models.Produto;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CompraDTO {
    @CPF
    private String cpf;
    @NotNull
    private List<ProdutoDTO> produtos;


    public CompraDTO(@CPF String cpf, @NotNull List<ProdutoDTO> produtos) {
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

    public List<ProdutoDTO> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoDTO> produtos) {
        this.produtos = produtos;
    }

    public Compra converterCompraDTO(Cliente cliente, List<Produto> produtos){
        Compra compra = new Compra();
        compra.setCliente(cliente);
        compra.setListaDeProdutos(produtos);
        return compra;
    }
}
