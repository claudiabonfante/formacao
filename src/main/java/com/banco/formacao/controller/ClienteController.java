package com.banco.formacao.controller;

import com.banco.formacao.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody @Valid CadastroCliente cadastro, UriComponentsBuilder uriBuilder) {
            var cliente = new Cliente(cadastro);
            repository.save(cliente);

            var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

            return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));

    }


    @PutMapping
    public ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente cadastro){

        var cliente = repository.getReferenceById(cadastro.id());
        cliente.atualizarInformacoes(cadastro);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }


}
