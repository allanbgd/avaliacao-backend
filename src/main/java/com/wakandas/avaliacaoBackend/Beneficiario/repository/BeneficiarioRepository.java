package com.wakandas.avaliacaoBackend.Beneficiario.repository;
import com.wakandas.avaliacaoBackend.Documento.domain.Documento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository extends JpaRepository<Documento, Long> {
}
