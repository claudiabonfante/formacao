package com.banco.formacao.domain.cliente;

import com.banco.formacao.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CadastroCliente(
        @NotBlank
        Boolean ativo,
        @NotBlank
        String nome,
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,
        @NotNull
        @Valid
        DadosEndereco endereco) {


}

