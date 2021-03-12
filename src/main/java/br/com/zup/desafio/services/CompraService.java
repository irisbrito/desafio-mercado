package br.com.zup.desafio.services;

import br.com.zup.desafio.DTOs.CompraDTO;
import br.com.zup.desafio.models.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompraService {

    List<Compra> compras = new ArrayList<>();

    public Compra realizarCompra(Compra compra){
        compras.add(compra);
        return compra;
    }

    public List<Compra> listarCompras(){
        return compras;
    }


}
