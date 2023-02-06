package com.banco.formacao.domain.cliente;

import com.banco.formacao.domain.endereco.Endereco;

public record DadosAtualizacaoCliente(Long id, String nome, String email, String telefone, Endereco endereco, Boolean ativo) {
    public DadosAtualizacaoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco(), cliente.getAtivo());
    }
}

