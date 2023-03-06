package com.banco.formacao.repository;

import com.banco.formacao.model.cliente.CadastroCliente;
import com.banco.formacao.model.cliente.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ClienteSaveRepository {
    @Autowired
    private ClienteRepository repository;


    public Cliente salvarCliente(CadastroCliente cadastro) {
        var cliente = new Cliente(cadastro);
        repository.save(cliente);
        return cliente;
    }

}
