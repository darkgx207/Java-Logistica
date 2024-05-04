package com.guilherme.provajava.model.dto;


import jakarta.validation.constraints.NotNull;

public record ClienteDTO(
    @NotNull String nome,
    @NotNull String cnpj,
    @NotNull EnderecoDTO endereco
) {}
