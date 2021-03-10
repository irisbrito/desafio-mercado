package br.com.zup.desafio.controllers;

import br.com.zup.desafio.models.Cliente;
import br.com.zup.desafio.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("clientes/")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionarCliente(@RequestBody @Valid Cliente cliente){
        Cliente objCliente = clienteService.adicionarCliente(cliente);
        return objCliente;
    }
}
