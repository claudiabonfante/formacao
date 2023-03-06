package com.banco.formacao.service;

import com.banco.formacao.model.cliente.ClienteRequest;

public interface ClienteService {
    public default ClienteRequest incluir(ClienteRequest clienteRequest){

        return clienteRequest;
    }


    public default ClienteRequest atualizaCliente(ClienteRequest clienteRequestAtualiza){

        return clienteRequestAtualiza;
    }
}
