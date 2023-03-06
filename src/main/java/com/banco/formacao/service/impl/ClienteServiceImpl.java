package com.banco.formacao.service.impl;

import com.banco.formacao.model.cliente.Cliente;
import com.banco.formacao.model.cliente.ClienteRequest;
import com.banco.formacao.repository.ClienteRepository;
import com.banco.formacao.service.ClienteService;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    ClienteService service =  new ClienteServiceImpl();
    private ClienteRepository clienteRepository;


    public ClienteRequest incluir(ClienteRequest clienteRequest){
        var cliente = new Cliente(clienteRequest);

        service.incluir(clienteRequest);
        return clienteRequest;

    }


    public ClienteRequest atualizaCliente(ClienteRequest clienteRequestAtualiza){

        var cliente = new Cliente(clienteRequestAtualiza);

        service.atualizaCliente(clienteRequestAtualiza);
        return clienteRequestAtualiza;

    }


}
