package com.example.secondchallenge.persistence;

import lombok.Data;

@Data
public class ViaCEP {

    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String cep;
    private String logradouro;

}
