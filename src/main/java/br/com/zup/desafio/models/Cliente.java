package br.com.zup.desafio.models;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Cliente {

    @NotEmpty(message = "Nome não pode ficar vazio")
    @NotNull(message = "O nome é um campo obrigatório")
    private String nome;

    @CPF(message = "CPF inválido")
    private String CPF;

    @Email(message = "Email inválido")
    private String email;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
