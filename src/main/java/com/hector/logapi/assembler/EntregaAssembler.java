package com.hector.logapi.assembler;

import com.hector.logapi.dto.EntregaDto;
import com.hector.logapi.dto.input.EntregaInput;
import com.hector.logapi.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaDto toModel(Entrega entrega){
        return modelMapper.map(entrega, EntregaDto.class);
    }

    public List<EntregaDto> toCollectionModel(List<Entrega>entregas){
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInput entregaInput){
        return modelMapper.map(entregaInput,Entrega.class);
    }

}
