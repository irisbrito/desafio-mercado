package br.com.zup.desafio.services;

import br.com.zup.desafio.exceptions.ClienteExistenteEmailException;
import br.com.zup.desafio.exceptions.ClienteExistenteException;
import br.com.zup.desafio.exceptions.ClienteNaoEncontradoException;
import br.com.zup.desafio.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviço com as regras de negócio sobre Cliente
 */
@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    /**
     * Método para adicionar cliente no sistema
     * @param cliente
     * @return
     */
    public Cliente adicionarCliente(Cliente cliente){
        validarCadastro(cliente.getCpf());
        validarEmail(cliente.getEmail());
        clientes.add(cliente);
        return cliente;
    }

    /**
     * Método para pesquisar cliente de acordo com o cpf cadastrado
     * @param cpf
     * @return
     */
    public Cliente pesquisarClientePeloCPF(String cpf){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                return cliente;
            }
        }
        throw new ClienteNaoEncontradoException();
    }

    /**
     * Método para validação de cadastro, não permite que se cadastre um cliente com cpf repetido
     * @param cpf
     */
    public void validarCadastro(String cpf){
        for(Cliente cliente : clientes){
            if(cliente.getCpf().equalsIgnoreCase(cpf)){
                throw new ClienteExistenteException();
            }
        }
    }

    /**
     * Método para validação de cadastro, não permite que se cadastre um cliente com email repetido
     * @param email
     */
    public void validarEmail(String email){
        for(Cliente cliente : clientes) {
            if (cliente.getEmail().equalsIgnoreCase(email)) {
                throw new ClienteExistenteEmailException();
            }
        }
    }
}
