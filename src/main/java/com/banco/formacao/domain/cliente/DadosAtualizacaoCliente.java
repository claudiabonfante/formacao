package com.banco.formacao.domain.cliente;

import com.banco.formacao.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoCliente (

            @NotNull
            Long id,
            String nome,
            String telefone,

            Boolean ativo,
            DadosEndereco endereco) {
    }
