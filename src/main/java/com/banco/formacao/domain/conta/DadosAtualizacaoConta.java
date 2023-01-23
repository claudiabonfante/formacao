package com.banco.formacao.domain.conta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConta(

    @NotNull
    Long id,
    String conta,
    String agencia,
    Boolean ativa
){
}
