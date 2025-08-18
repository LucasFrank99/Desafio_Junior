package com.lfrank.transacao.infrastructure.repository;

import com.lfrank.transacao.infrastructure.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
