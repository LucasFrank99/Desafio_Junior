package com.lfrank.transacao.service;

import com.lfrank.transacao.controller.TransacaoDTO;
import com.lfrank.transacao.exceptions.BadRequestException;
import com.lfrank.transacao.infrastructure.entity.TipoUsuario;
import com.lfrank.transacao.infrastructure.entity.Transacoes;
import com.lfrank.transacao.infrastructure.entity.Usuario;
import com.lfrank.transacao.infrastructure.repository.TransacoesRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransacaoService {

    private final UsuarioService usuarioService;
    private final AutorizacaoService autorizacaoService;
    private final CarteiraService carteiraService;
    private final TransacoesRepository transacoesRepository;
    private final NotificacaoService notificacaoService;


    @Transactional
    public void transferirValores(TransacaoDTO transacaoDTO){
        Usuario pagador = usuarioService.buscarUsuario(transacaoDTO.payer());
        Usuario recebedor = usuarioService.buscarUsuario(transacaoDTO.payee());

        verificaPagadorLojista(pagador);
        validarSaldoUsuario(pagador, transacaoDTO.value());
        validarTransferencia();

        pagador.getCarteira().setSaldo(pagador.getCarteira().getSaldo().subtract(transacaoDTO.value()));
        carteiraService.salvar(pagador.getCarteira());
        recebedor.getCarteira().setSaldo(pagador.getCarteira().getSaldo().add(transacaoDTO.value()));
        carteiraService.salvar(recebedor.getCarteira());

        Transacoes transacoes = Transacoes.builder()
                .valor(transacaoDTO.value())
                .pagador(pagador)
                .recebedor(recebedor)
                .build();

        transacoesRepository.save(transacoes);
        enviarNotificacao();

    }

    private void verificaPagadorLojista(Usuario usuario){
        try{
            if (usuario.getTipoUsuario().equals(TipoUsuario.LOJISTA)){
                throw new IllegalArgumentException("Operação nao autorizada para este tipo de usuário");
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarSaldoUsuario(Usuario usuario, BigDecimal valor){
        try{
            if (usuario.getCarteira().getSaldo().compareTo(valor) < 0){
                throw new IllegalArgumentException("Saldo insuficiente");
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void validarTransferencia(){
        try{
            if (!autorizacaoService.validarTransferencia()){
                throw new IllegalArgumentException("Operação não autorizada pela API");
            }
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void enviarNotificacao(){
        try{
            notificacaoService.enviarNotificacao();
        } catch (HttpClientErrorException e){
        throw new BadRequestException("Erro ao enviar notificação");
        }
    }


}
