package com.banco.formacao.domain.conta;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

import java.text.DecimalFormat;


public record CadastroConta(
    @NotBlank
    String agencia,

    @NotBlank
    String conta,

    @DecimalMin
    DecimalFormat saldo,
    Boolean ativa
){}