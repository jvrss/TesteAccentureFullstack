package com.accenture.testeaccenturefullstackbackend.model;

import lombok.Data;

@Data
public class Cep {

    private String cep;

    private String uf;

    private String cidade;

    private String bairro;

    private String logradouro;

}
