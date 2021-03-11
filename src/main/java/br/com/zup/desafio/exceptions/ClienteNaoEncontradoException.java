package br.com.zup.desafio.exceptions;

public class ClienteNaoEncontradoException extends ExcecaoBasica{
    public ClienteNaoEncontradoException() {
        super("Cliente não encontrado", 400, "Bad Request", "CPF", "Objeto não cadastrado");
    }
}
