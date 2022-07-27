package com.hector.logapi.dto.input;

import lombok.Data;


import javax.validation.constraints.NotBlank;

@Data
public class DestinatarioInput {

    @NotBlank
    private String nome;

    @NotBlank
    private String Logradouro;

    @NotBlank
    private String numero;

    @NotBlank
    private String complemento;

    @NotBlank
    private String bairro;
}
