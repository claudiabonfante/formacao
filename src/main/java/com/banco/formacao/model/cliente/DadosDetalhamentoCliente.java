package com.banco.formacao.model.cliente;

import com.banco.formacao.model.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String email, String telefone, Endereco endereco, Boolean ativo) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco(), cliente.getAtivo());
    }
}
