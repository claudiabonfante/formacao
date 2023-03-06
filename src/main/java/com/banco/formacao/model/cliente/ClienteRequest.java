package com.banco.formacao.model.cliente;

import com.banco.formacao.model.endereco.Endereco;

public record ClienteRequest(Long id, String nome, String email, String telefone, Endereco endereco, Boolean ativo) {
    public ClienteRequest(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco(), cliente.getAtivo());
    }
}

