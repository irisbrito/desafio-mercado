package br.com.zup.desafio.services;

import br.com.zup.desafio.models.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    private List<Cliente> clientes = new ArrayList<>();

    public Cliente adicionarCliente(Cliente cliente){
        clientes.add(cliente);
        return cliente;
    }
}