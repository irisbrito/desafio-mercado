package br.com.zup.desafio.services;

import br.com.zup.desafio.exceptions.ClienteExistenteEmailException;
import br.com.zup.desafio.exceptions.ClienteExistenteException;
import br.com.zup.desafio.exceptions.ClienteNaoEncontradoException;
import br.com.zup.desafio.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente adicionarCliente(Cliente cliente){
        validarCadastro(cliente.getCpf());
        validarEmail(cliente.getEmail());
        clientes.add(cliente);
        return cliente;
    }

    public Cliente pesquisarClientePeloCPF(String cpf){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                return cliente;
            }
        }
        throw new ClienteNaoEncontradoException();
    }

    public void validarCadastro(String cpf){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                throw new ClienteExistenteException();
            }
        }
    }

    public void validarEmail(String email){
        for(Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                throw new ClienteExistenteEmailException();
            }
        }
    }
}
