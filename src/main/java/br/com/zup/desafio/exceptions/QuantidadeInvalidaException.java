package br.com.zup.desafio.exceptions;

public class QuantidadeInvalidaException extends ExcecaoBasica{
    public QuantidadeInvalidaException() {
        super("Quantidade invalida", 400, "Bad Request", "quantidade", "Produto em falta");
    }
}
