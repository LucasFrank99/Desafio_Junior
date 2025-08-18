package com.lfrank.transacao.service;

import com.lfrank.transacao.infrastructure.clients.AutorizacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AutorizacaoService {

    private final AutorizacaoClient client;

    public boolean validarTransferencia(){
        if (Objects.equals(client.validarAutorizacao().data().authorization(), "true")) {
            return true;
        } else {
            return false;
        }
    }
}
