package com.hector.logapi.controller;

import com.hector.logapi.assembler.OcorrenciaAssembler;
import com.hector.logapi.dto.OcorrenciaDto;
import com.hector.logapi.dto.input.OcorrenciaInput;
import com.hector.logapi.model.Entrega;
import com.hector.logapi.model.Ocorrencia;
import com.hector.logapi.service.BuscaEntregaService;
import com.hector.logapi.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaAssembler ocorrenciaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaDto registrar(@PathVariable Long entregaId,
                                   @Valid @RequestBody OcorrenciaInput ocorrenciaInput){
        Ocorrencia ocorrenciaRegistrada =  registroOcorrenciaService
                .registrar(entregaId, ocorrenciaInput.getDescricao());
        return ocorrenciaAssembler.toModel(ocorrenciaRegistrada);

    }

    @GetMapping
    public List<OcorrenciaDto> listar(@PathVariable Long entregaId){
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return ocorrenciaAssembler.toCollectionModel(entrega.getOcorrencias());
    }

}
