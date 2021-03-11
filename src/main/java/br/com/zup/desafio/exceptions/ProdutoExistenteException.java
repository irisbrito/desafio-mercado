package br.com.zup.desafio.exceptions;

public class ProdutoExistenteException extends ExcecaoBasica {
    public ProdutoExistenteException() {
        super("Produto já cadastrado", 400, "Unprocessable Entity", "nome", "Objeto já existe");
    }
}
