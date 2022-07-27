package com.hector.logapi.dto.input;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ClienteIdInput {

    @NotNull
    private Long id;
}
