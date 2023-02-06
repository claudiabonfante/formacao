package com.banco.formacao.controller;


import com.banco.formacao.domain.cliente.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarCliente(@RequestBody @Valid CadastroCliente cadastro, UriComponentsBuilder uriBuilder) {
        var cliente = new Cliente(cadastro);
        repository.save(cliente);

        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCliente(cliente));

    }


    @PutMapping
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody @Valid DadosAtualizacaoCliente atualiza) {

        var cliente = repository.getReferenceById(atualiza.id());
        cliente.atualizarInformacoes(atualiza);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @GetMapping
    public ResponseEntity<Page<DadosDetalhamentoCliente>> listar(@PageableDefault(size = 10, sort={"nome"}) Pageable paginacao) {

        var page = repository.findAllByAtivoTrue(paginacao).map(DadosDetalhamentoCliente::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoCliente(cliente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity inativar(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.inativar();

        return ResponseEntity.noContent().build();
    }
}
