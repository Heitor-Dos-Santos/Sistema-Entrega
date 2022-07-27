package com.hector.logapi.service;


import com.hector.logapi.Repository.EntregaRepository;
import com.hector.logapi.model.Cliente;
import com.hector.logapi.model.Entrega;
import com.hector.logapi.model.StatusEntrega;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private CatalogoClienteService catalogoClienteService;
    @Transactional
    public Entrega solicitar(Entrega entrega){
       Cliente cliente =  catalogoClienteService.buscar(entrega.getCliente().getId());
       entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());
        return entregaRepository.save(entrega);

    }
}
