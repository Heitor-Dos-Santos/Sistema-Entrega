package com.hector.logapi.dto;

import com.hector.logapi.model.StatusEntrega;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class EntregaDto {

    private Long id;
    private String nomeCliente;
    private DestinatarioDto destinatarioDto;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dataFinalizacao;
}
