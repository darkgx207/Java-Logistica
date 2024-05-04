package com.guilherme.provajava.model.dto;

import jakarta.validation.constraints.NotNull;

public record EnderecoDTO(
    @NotNull String cep,
    @NotNull String logradouro,
    @NotNull String cidade,
    @NotNull String estado,
    @NotNull Double latitude,
    @NotNull Double longitude
) { }
