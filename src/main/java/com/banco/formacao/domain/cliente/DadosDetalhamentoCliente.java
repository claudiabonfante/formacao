package com.banco.formacao.domain.cliente;

import com.banco.formacao.domain.cliente.Cliente;
import com.banco.formacao.domain.endereco.Endereco;

public record DadosDetalhamentoCliente(Long id, String nome, String email, String telefone, Endereco endereco, Boolean ativo) {
    public DadosDetalhamentoCliente(Cliente cliente) {
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getTelefone(), cliente.getEndereco(), cliente.getAtivo());
    }
}
