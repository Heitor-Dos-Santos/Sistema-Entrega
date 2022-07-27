package com.hector.logapi.dto.input;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OcorrenciaInput {

    @NotBlank
    private String descricao;

}
