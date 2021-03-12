package br.com.zup.desafio.services;

import br.com.zup.desafio.exceptions.ProdutoExistenteException;
import br.com.zup.desafio.exceptions.ProdutoNaoEncontradoException;
import br.com.zup.desafio.exceptions.QuantidadeInvalidaException;
import br.com.zup.desafio.models.Produto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviço com as regras de negócio sobre Produto
 */
@Service
public class ProdutoService {
    private List<Produto> produtos = new ArrayList<>();

    /**
     * Método para adicionar produto no sistema
     * @param produto
     * @return
     */
    public Produto adicionarProduto(Produto produto){
            pesquisarProdutoPeloNome(produto.getNome());
            produtos.add(produto);
            return produto;
    }

    /**
     * Método para pesquisar os produtos cadastrados
     * @return lista dos produtos
     */
    public List<Produto> pesquisarProdutos(){
        return produtos;
    }

    /**
     * Método para pesquisar o produto de acordo com o nome
     * @param nome
     */
    public void pesquisarProdutoPeloNome(String nome){
        for(Produto produto : produtos){
            if(produto.getNome().equalsIgnoreCase(nome)){
                throw new ProdutoExistenteException();
            }
        }
    }

    /**
     *Método que adiciona os produtos na compra do cliente
     * @param produtoDTOs
     * @return os produtos comprados
     */
    public List<Produto> adicionarProdutosNaCompra(List<Produto> produtoDTOs) {

        List<Produto> produtosDaCompra = new ArrayList<>();

        for (Produto produtoDTO : produtoDTOs) {
            for (Produto produto : this.produtos) {
                if (produto.getNome().equalsIgnoreCase(produtoDTO.getNome()) && validarQuantidade(produto)){
                    produtosDaCompra.add(produto);
                    return produtosDaCompra;
                }
            }
        }

        throw new ProdutoNaoEncontradoException();
    }

    /**
     * Método que valida a quantidade de produtos
     * @param produto
     * @return true se a quantidade for maior que 0
     */
    public boolean validarQuantidade(Produto produto){

        if(produto.getQuantidade() > 0){
            return true;
        }

        throw new QuantidadeInvalidaException("O produto " + produto + " está indisponível");
    }
}
