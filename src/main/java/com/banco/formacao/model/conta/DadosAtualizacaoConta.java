package com.banco.formacao.model.conta;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConta(

    @NotNull
    Long id,
    String conta,
    String agencia,
    Boolean ativa
){
}
