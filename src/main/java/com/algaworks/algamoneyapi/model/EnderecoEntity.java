package com.algaworks.algamoneyapi.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@Getter
@Setter
public class EnderecoEntity {

    @NotNull
    private String logradouro;
    @NotNull
    private String numero;

    private String complemento;

    @NotNull
    private String bairro;

    @NotNull
    private String cep;

    @NotNull
    private String cidade;

    @NotNull
    private String estado;
}
