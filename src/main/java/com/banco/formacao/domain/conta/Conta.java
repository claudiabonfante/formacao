package com.banco.formacao.domain.conta;

import com.banco.formacao.domain.cliente.DadosAtualizacaoCliente;
import com.banco.formacao.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.DecimalFormat;

@Table(name = "contas")
@Entity(name = "Conta")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
    private String conta;

    private DecimalFormat saldo;
    private Boolean ativa;

    public Conta(CadastroConta conta){
        this.ativa = true;
        this.agencia = conta.agencia();
        this.conta = conta.conta();
        this.saldo = conta.saldo();
        this.ativa = conta.ativa();
    }

    public void atualizarInformacoes(DadosAtualizacaoConta conta) {
        if (conta.agencia() != null) {
            this.agencia = conta.agencia();
        }
        if (conta.ativa() != null) {
            this.ativa = conta.ativa();
        }


    }

}
