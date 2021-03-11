package br.com.zup.desafio.exceptions;

public class ProdutoNaoEncontradoException extends ExcecaoBasica{
    public ProdutoNaoEncontradoException() {
        super("Produto não encontrado", 400, "Bad Request", "nome", "Objeto não cadastrado");
    }
}
