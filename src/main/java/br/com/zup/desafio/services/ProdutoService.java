package br.com.zup.desafio.services;

import br.com.zup.desafio.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    public Produto adicionarProduto(Produto produto){
        produtos.add(produto);
        return produto;
    }

}
