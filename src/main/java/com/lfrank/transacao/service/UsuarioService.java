package com.lfrank.transacao.service;

import com.lfrank.transacao.exceptions.UserNotFound;
import com.lfrank.transacao.infrastructure.entity.Usuario;
import com.lfrank.transacao.infrastructure.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario buscarUsuario(Long id){
        return repository.findById(id).orElseThrow(() -> new UserNotFound("Usuário não encontrado"));
    }
}
