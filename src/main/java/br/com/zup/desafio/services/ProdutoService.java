package br.com.zup.desafio.services;

import br.com.zup.desafio.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public Produto adicionarProduto(Produto produto){
            pesquisarProdutoPeloNome(produto.getNome());
            produtos.add(produto);
            return produto;
    }

    public List<Produto> pesquisarProdutos(){
        return produtos;
    }

    public void pesquisarProdutoPeloNome(String nome){
        for(Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                throw new RuntimeException("Produto já cadastrado");
            }
        }
    }

}
