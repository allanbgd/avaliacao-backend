package com.wakandas.avaliacaoBackend.Documento.domain;
import java.time.LocalDateTime;

import com.wakandas.avaliacaoBackend.Beneficiario.domain.Beneficiario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Gera o ID automaticamente
    private Long id;
    private String tipoDocumento;
    private String descricao;
    private LocalDateTime dataInclusao = LocalDateTime.now();
    private LocalDateTime dataAtualizacao =LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;

    
}
