package com.banco.formacao.domain.conta;

import com.banco.formacao.domain.cliente.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
        Page<Conta> findAllByAtivaTrue(Pageable paginacao);

}
