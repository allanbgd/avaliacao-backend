package com.wakandas.avaliacaoBackend.Documento.repository;
import com.wakandas.avaliacaoBackend.Beneficiario.domain.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentoRepository extends JpaRepository<Beneficiario, Long> {
}
