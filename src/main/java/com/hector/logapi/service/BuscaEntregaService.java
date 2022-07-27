package com.hector.logapi.service;

import com.hector.logapi.Repository.EntregaRepository;
import com.hector.logapi.exception.EntidadeNaoEncontradaException;
import com.hector.logapi.exception.NegocioException;
import com.hector.logapi.model.Entrega;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega nao encontrada"));
    }

}
