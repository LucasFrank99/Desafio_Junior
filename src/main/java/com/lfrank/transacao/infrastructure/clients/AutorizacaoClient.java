package com.lfrank.transacao.infrastructure.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "${client.authorize-api.url}",
             name = "autorizacao-client")

public interface AutorizacaoClient {


    @GetMapping
    AutorizacaoDTO validarAutorizacao();


}
