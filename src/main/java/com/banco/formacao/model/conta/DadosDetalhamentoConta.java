package com.banco.formacao.model.conta;

public record DadosDetalhamentoConta(Long id, String agencia, String conta, Boolean ativa) {
    public DadosDetalhamentoConta(Conta conta) {
        this(conta.getId(), conta.getAgencia(), conta.getConta(), conta.getAtiva());}

    }
