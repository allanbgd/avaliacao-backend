package com.wakandas.avaliacaoBackend.Beneficiario.controller;
import com.wakandas.avaliacaoBackend.Documento.*;
import com.wakandas.avaliacaoBackend.Beneficiario.repository.*;
import com.wakandas.avaliacaoBackend.Documento.repository.*;
import com.wakandas.avaliacaoBackend.Beneficiario.*;
import com.wakandas.avaliacaoBackend.Beneficiario.domain.Beneficiario;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/api/beneficiarios")
@RequiredArgsConstructor
public class BeneficiarioController {
    private final BeneficiarioRepository beneficiarioRepository;

    @PostMapping
    public String postMethodName(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    public Beneficiario cadastrar(@RequestBody Beneficiario beneficiario) {
        beneficiario.getDocumentos().forEach(doc -> doc.setBeneficiario(beneficiario));
        return beneficiarioRepository.save(beneficiario);
    }

    @GetMapping
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    public List<Beneficiario> listarTodos() {
        return beneficiarioRepository.findAll();
    }

    @GetMapping("/{id}/documentos")
    public List<Documento> listarDocumentos(@PathVariable Long id) {
        return beneficiarioRepository.findById(id)
            .map(Beneficiario::getDocumentos)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiário não encontrado"));
    }

    @PutMapping("/{id}")
    public Beneficiario atualizar(@PathVariable Long id, @RequestBody Beneficiario novo) {
        return beneficiarioRepository.findById(id).map(beneficiario -> {
            beneficiario.setNome(novo.getNome());
            beneficiario.setTelefone(novo.getTelefone());
            beneficiario.setDataNascimento(novo.getDataNascimento());
            beneficiario.setDataAtualizacao(LocalDateTime.now());
            return beneficiarioRepository.save(beneficiario);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Beneficiário não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        beneficiarioRepository.deleteById(id);
    }
}


