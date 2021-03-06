package br.com.zup.desafio.controllers;

import br.com.zup.desafio.models.Cliente;
import br.com.zup.desafio.models.Compra;
import br.com.zup.desafio.DTOs.CompraDTO;
import br.com.zup.desafio.models.Produto;
import br.com.zup.desafio.services.ClienteService;
import br.com.zup.desafio.services.CompraService;
import br.com.zup.desafio.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("compras/")
public class CompraController {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private CompraService compraService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Compra realizarCompra(@RequestBody CompraDTO compraDTO) {
        Cliente cliente = clienteService.pesquisarClientePeloCPF(compraDTO.getCpf());
        List<Produto> produtos = produtoService.adicionarProdutosNaCompra(compraDTO.getProdutos());
       return compraService.realizarCompra(compraDTO.converterCompraDTO(cliente, produtos));
    }

    @GetMapping
    public List<Compra> listarCompras(){
        return compraService.listarCompras();
    }

    @GetMapping("{cpf}/")
    public List <Compra> pesquisarCompraPeloCpf(@PathVariable String cpf){
        return compraService.pesquisarCompraPeloCpf(cpf);
    }

}
