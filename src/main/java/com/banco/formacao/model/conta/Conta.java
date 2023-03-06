package com.banco.formacao.model.conta;

import jakarta.persistence.*;


import java.text.DecimalFormat;

@Table(name = "contas")
@Entity(name = "Conta")

public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String agencia;
    private String conta;

    private DecimalFormat saldo;
    private Boolean ativa;

    public Long getId() {
        return id;
    }

    public String getAgencia() {
        return agencia;
    }

    public String getConta() {
        return conta;
    }

    public DecimalFormat getSaldo() {
        return saldo;
    }

    public Boolean getAtiva() {
        return ativa;
    }

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
