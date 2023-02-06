package com.banco.formacao.domain.cliente;

import com.banco.formacao.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "clientes")
@Entity(name = "Cliente")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean ativo;

    private String nome;
    private String email;

    private String telefone;

    @Embedded
    private Endereco endereco;


    public Cliente(CadastroCliente cadastro) {
        this.ativo = true;
        this.nome = cadastro.nome();
        this.email = cadastro.email();
        this.telefone = cadastro.telefone();
        this.endereco = new Endereco(cadastro.endereco());
        this.ativo = cadastro.ativo();
    }

    public void atualizarInformacoes(DadosAtualizacaoCliente dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco = dados.endereco();
        }

    }

    public void inativar() {
        this.ativo = false;
    }
}


