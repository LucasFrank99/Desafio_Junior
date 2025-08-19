package com.lfrank.transacao.controller;

import com.lfrank.transacao.service.TransacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/transfer")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public ResponseEntity<Void> realizarTransacao(@RequestBody TransacaoDTO transacaoDTO){
        transacaoService.transferirValores(transacaoDTO);
        return ResponseEntity.accepted().build();
    }
}
