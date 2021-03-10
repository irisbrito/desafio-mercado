package br.com.zup.desafio.services;

import br.com.zup.desafio.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente adicionarCliente(Cliente cliente){
        validarCadastro(cliente.getCPF(), cliente.getEmail());
        clientes.add(cliente);
        return cliente;
    }

    public Cliente pesquisarClientePeloCPF(String CPF){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equalsIgnoreCase(CPF)){
                return cliente;
            }
        }
        throw new RuntimeException("Cliente não encontrado");
    }

    public void validarCadastro(String CPF, String email){
        for(Cliente cliente : clientes){
            if(cliente.getCPF().equalsIgnoreCase(CPF) || cliente.getEmail().equalsIgnoreCase(email)){
                throw new RuntimeException("Cliente já cadastrado");
            }
        }
    }
}
