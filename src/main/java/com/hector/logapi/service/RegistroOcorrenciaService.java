package com.hector.logapi.service;


import com.hector.logapi.model.Entrega;
import com.hector.logapi.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

     private BuscaEntregaService buscaEntregaService;

     @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
         return entrega.adicionarOcorrencia(descricao);
    }
}
