package com.lfrank.transacao.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(url = "${client.notify-api.url}",
             name = "notify-client")

public interface NotificacaoClient {

    @PostMapping
    void notificarTransacao();

}
