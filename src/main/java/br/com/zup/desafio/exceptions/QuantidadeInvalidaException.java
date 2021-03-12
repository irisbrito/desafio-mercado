package br.com.zup.desafio.exceptions;

public class QuantidadeInvalidaException extends ExcecaoBasica{
    public QuantidadeInvalidaException(String mensagem) {
        super(mensagem, 400, "Bad Request", "quantidade", "Produto em falta");
    }
}
