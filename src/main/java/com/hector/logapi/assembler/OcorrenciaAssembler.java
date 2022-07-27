package com.hector.logapi.assembler;

import com.hector.logapi.dto.EntregaDto;
import com.hector.logapi.dto.OcorrenciaDto;
import com.hector.logapi.model.Entrega;
import com.hector.logapi.model.Ocorrencia;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class OcorrenciaAssembler {

    private ModelMapper modelMapper;

    public OcorrenciaDto toModel(Ocorrencia ocorrencia){
        return modelMapper.map(ocorrencia, OcorrenciaDto.class);
    }

    public List<OcorrenciaDto> toCollectionModel(List<Ocorrencia>ocorrencias){
        return ocorrencias.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}
