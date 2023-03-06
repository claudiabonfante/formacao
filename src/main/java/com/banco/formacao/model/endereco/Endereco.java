package com.banco.formacao.model.endereco;

import jakarta.persistence.Embeddable;


@Embeddable

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(Endereco dados) {
        this.logradouro = dados.logradouro();
        this.bairro = dados.bairro();
        this.cep = dados.cep();
        this.uf = dados.uf();
        this.cidade = dados.cidade();
        this.numero = dados.numero();
        this.complemento = dados.complemento();
    }

    public void atualizarInformacoes(DadosEndereco atualiza) {
        if (atualiza.logradouro() != null) {
            this.logradouro = atualiza.logradouro();
        }
        if (atualiza.bairro() != null) {
            this.bairro = atualiza.bairro();
        }
        if (atualiza.cep() != null) {
            this.cep = atualiza.cep();
        }
        if (atualiza.uf() != null) {
            this.uf = atualiza.uf();
        }
        if (atualiza.cidade() != null) {
            this.cidade = atualiza.cidade();
        }
        if (atualiza.numero() != null) {
            this.numero = atualiza.numero();
        }
        if (atualiza.complemento() != null) {
            this.complemento = atualiza.complemento();
        }
    }
}
