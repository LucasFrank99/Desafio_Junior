package com.lfrank.transacao.service;

import com.lfrank.transacao.infrastructure.clients.NotificacaoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoClient client;

    public void enviarNotificacao(){
        client.notificarTransacao();
    }
}
