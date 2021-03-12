package br.com.zup.desafio.services;

import br.com.zup.desafio.DTOs.CompraDTO;
import br.com.zup.desafio.models.Compra;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de serviço com as regras de negócio de Compra
 */
@Service
public class CompraService {

    List<Compra> compras = new ArrayList<>();

    /**
     * Método para adicionar nova compra
     * @param compra
     * @return compra realizada
     */
    public Compra realizarCompra(Compra compra){
        compras.add(compra);
        return compra;
    }

    /**
     * Método para retonar todas as compras
     * @return lista das compras
     */
    public List<Compra> listarCompras(){
        return compras;
    }

    /**
     * Método para pesquisar compra de acordo com o cpf do cliente
     * @param cpf
     * @return a lista de compras do cliente
     */
    public List<Compra> pesquisarCompraPeloCpf(String cpf){
        List<Compra> comprasDoCliente = new ArrayList<>();

        for(Compra compra : compras){
            if(compra.getCliente().getCpf().equals(cpf)){
                comprasDoCliente.add(compra);
                return comprasDoCliente;
            }
        }
        throw new RuntimeException();
    }

}
