package com.lfrank.transacao.service;

import com.lfrank.transacao.infrastructure.entity.Carteira;
import com.lfrank.transacao.infrastructure.repository.CarteiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository repository;

    public void salvar(Carteira carteira){
        repository.save(carteira);
    }
}
