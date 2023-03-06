package com.banco.formacao.model.cliente;

import com.banco.formacao.model.endereco.Endereco;
import jakarta.persistence.*;


@Table(name = "clientes")
@Entity(name = "Cliente")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean ativo;

    private String nome;
    private String email;

    public Boolean getAtivo() {
        return ativo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    private String telefone;

    @Embedded
    private Endereco endereco;

    public Long getId() {
        return id;
    }
    public Cliente(ClienteRequest cadastro) {
        this.ativo = true;
        this.nome = cadastro.nome();
        this.email = cadastro.email();
        this.telefone = cadastro.telefone();
        this.endereco = new Endereco(cadastro.endereco());
        this.ativo = cadastro.ativo();
    }

//    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
//        if (dados.nome() != null) {
//            this.nome = dados.nome();
//        }
//        if (dados.telefone() != null) {
//            this.telefone = dados.telefone();
//        }
//        if (dados.endereco() != null) {
//            this.endereco = dados.endereco();
//        }
//
//    }

    public void inativar() {
        this.ativo = false;
    }
}


