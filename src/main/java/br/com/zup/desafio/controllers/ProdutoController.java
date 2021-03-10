package br.com.zup.desafio.controllers;

import br.com.zup.desafio.models.Produto;
import br.com.zup.desafio.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("produtos/")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionarProduto(@RequestBody @Valid Produto produto){
        Produto objetoProduto = produtoService.adicionarProduto(produto);
        return objetoProduto;
    }

    @GetMapping
    public List<Produto> mostrarProdutos(){
        return produtoService.pesquisarProdutos();
    }
}
