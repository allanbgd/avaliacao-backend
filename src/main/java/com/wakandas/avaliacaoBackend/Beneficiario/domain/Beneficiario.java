package com.wakandas.avaliacaoBackend.Beneficiario.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id;

    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDateTime dataInclusao = LocalDateTime.now();
    private LocalDateTime dataAtualizacao = LocalDateTime.now();

}
