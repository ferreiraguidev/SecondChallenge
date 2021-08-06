package com.example.secondchallenge.service;

import com.example.secondchallenge.persistence.ViaCEP;
import com.example.secondchallenge.repository.ViaCEPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CEPService {

    @Autowired
    private ViaCEPClient viaCEPClient;


    public ViaCEP getCep(String cep) {

        return viaCEPClient.buscaPorEndereco(cep);


    }

}
