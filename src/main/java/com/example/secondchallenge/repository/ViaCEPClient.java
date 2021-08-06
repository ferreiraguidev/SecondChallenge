package com.example.secondchallenge.repository;

import com.example.secondchallenge.persistence.Address;
import com.example.secondchallenge.persistence.ViaCEP;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "https://viacep.com.br/ws/", name = "viacep")
public interface ViaCEPClient {


    @GetMapping("{cep}/json")
    ViaCEP buscaPorEndereco(@PathVariable("cep") String cep);


}



