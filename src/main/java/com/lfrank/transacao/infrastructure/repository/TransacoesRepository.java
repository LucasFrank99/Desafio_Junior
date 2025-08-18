package com.lfrank.transacao.infrastructure.repository;

import com.lfrank.transacao.infrastructure.entity.Carteira;
import com.lfrank.transacao.infrastructure.entity.Transacoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacoesRepository extends JpaRepository<Transacoes, Long> {
}
