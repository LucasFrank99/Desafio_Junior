package com.lfrank.transacao.infrastructure.repository;

import com.lfrank.transacao.infrastructure.entity.Carteira;
import com.lfrank.transacao.infrastructure.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
