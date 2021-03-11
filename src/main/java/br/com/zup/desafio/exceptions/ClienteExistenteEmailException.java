package br.com.zup.desafio.exceptions;

public class ClienteExistenteEmailException extends ExcecaoBasica{
    public ClienteExistenteEmailException() {
        super("Cliente já cadastrado", 422, "Unprocessable Entity", "email", "E-mail já cadastrado");
    }
}
