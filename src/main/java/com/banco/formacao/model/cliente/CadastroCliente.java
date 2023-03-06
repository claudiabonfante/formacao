package com.banco.formacao.model.cliente;

import com.banco.formacao.model.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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

