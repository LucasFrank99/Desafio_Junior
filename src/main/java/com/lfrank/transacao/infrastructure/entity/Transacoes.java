package com.lfrank.transacao.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transacao")
@Table
public class Transacoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private BigDecimal valor;
   private LocalDateTime dataHoraTransacao;

   @JoinColumn(name = "recebedor_id")
   @ManyToOne
    private Usuario recebedor;

   @JoinColumn(name = "pagador_id")
   @ManyToOne
   private Usuario pagador;

   @PrePersist
    void prePersist(){
       dataHoraTransacao = LocalDateTime.now();
   }
}
