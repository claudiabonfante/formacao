package com.banco.formacao.controller;


import com.banco.formacao.model.cliente.CadastroCliente;
import com.banco.formacao.model.cliente.Cliente;
import com.banco.formacao.model.cliente.ClienteRequest;
import com.banco.formacao.model.cliente.DadosDetalhamentoCliente;
import com.banco.formacao.service.ClienteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

@Autowired
private ClienteService service;


    public ClienteController(ClienteService clienteService){
        this.service = clienteService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody ClienteRequest clienteRequest) {
        var cliente = service.incluir(clienteRequest);
        var clienteResponse = new IncluirClienteResponse();

        return new ResponseEntity<>(clienteResponse, HttpStatus.CREATED);

    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody @Valid ClienteRequest atualiza) {

        var cliente = repository.getReferenceById(atualiza.id());
        cliente.atualizarInformacoes(atualiza);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listar() {

        return new ResponseEntity<>(clienteService.listar(), HttpStatus.OK);
//        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);
//
//        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> detalhar(@PathVariable("id") Long id){
//        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(clienteService.getCliente(id), HttpStatus.OK);
    }
//
//    @DeleteMapping("/{id}")
//    @Transactional
//    public ResponseEntity inativar(@PathVariable Long id){
//        var cliente = repository.getReferenceById(id);
//        cliente.inativar();
//
//        return ResponseEntity.noContent().build();
//    }
}
