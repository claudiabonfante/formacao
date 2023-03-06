package com.banco.formacao.repository;

import com.banco.formacao.model.conta.Conta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
        Page<Conta> findAllByAtivaTrue(Pageable paginacao);

}
