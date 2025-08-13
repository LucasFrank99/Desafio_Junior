package com.lfrank.transacao.infrastructure.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "usuario")
@Table
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeCompleto;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(unique = true, nullable = false)
    private String cpfCnpj;
    private String senha;
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;


    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Carteira carteira;
}
