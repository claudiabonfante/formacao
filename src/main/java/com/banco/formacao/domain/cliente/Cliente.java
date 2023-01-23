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
        private String nome;
        private String email;

        private String telefone;

        @Embedded
        private Endereco endereco;

        private Boolean ativo;

        public Cliente(CadastroCliente cadastro) {
            this.ativo = true;
            this.nome = cadastro.nome();
            this.email = cadastro.email();
            this.telefone = cadastro.telefone();
            this.endereco = new Endereco(cadastro.endereco());
            this.ativo = cadastro.ativo();
        }

        public void atualizarInformacoes(DadosAtualizacaoCliente cadastro) {
            if (cadastro.nome() != null) {
                this.nome = cadastro.nome();
            }
            if (cadastro.telefone() != null) {
                this.telefone = cadastro.telefone();
            }
            if (cadastro.endereco() != null) {
                this.endereco.atualizarInformacoes(cadastro.endereco());
            }

        }

        public void desativar() {
            this.ativo = false;
        }
    }


