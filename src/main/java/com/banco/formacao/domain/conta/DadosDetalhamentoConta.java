package com.banco.formacao.domain.conta;

import com.banco.formacao.domain.cliente.Cliente;

public record DadosDetalhamentoConta(Long id, String agencia, String conta, Boolean ativa) {
    public DadosDetalhamentoConta(Conta conta) {
        this(conta.getId(), conta.getAgencia(), conta.getConta(), conta.getAtiva());}

    }
