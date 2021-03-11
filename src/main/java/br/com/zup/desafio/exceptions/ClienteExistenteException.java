package br.com.zup.desafio.exceptions;

public class ClienteExistenteException extends ExcecaoBasica{

    public ClienteExistenteException() {
        super("Cliente já cadastrado", 422, "Unprocessable Entity", "CPF", "Objeto já existe");
    }
}
