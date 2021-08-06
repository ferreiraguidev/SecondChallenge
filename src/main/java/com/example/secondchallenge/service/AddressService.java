package com.example.secondchallenge.service;


import com.example.secondchallenge.model.AddressPostRequestBody;
import com.example.secondchallenge.persistence.Address;
import com.example.secondchallenge.persistence.ViaCEP;
import com.example.secondchallenge.repository.AddressRepository;
import com.example.secondchallenge.repository.UserRepository;
import com.example.secondchallenge.repository.ViaCEPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    CEPService cepService;

    public Address save(AddressPostRequestBody addressPostRequestBody) {

        ViaCEP cep = cepService.getCep(addressPostRequestBody.getCep());
        if(cep.getCep() != null){

            Address address = Address.builder()
                    .logradouro(cep.getLogradouro())
                    .number(addressPostRequestBody.getNumber())
                    .city(cep.getLocalidade())
                    .county(cep.getUf())
                    .cep(cep.getCep())
                    .district(cep.getBairro())
                    .users(userRepository.findById(addressPostRequestBody.getUserId())
                            .orElseThrow(() -> new NullPointerException("Not found")))
                    .build();

            return addressRepository.save(address);

        }

        Address address = Address.builder()
                .logradouro(addressPostRequestBody.getLogradouro())
                .number(addressPostRequestBody.getNumber())
                .city(addressPostRequestBody.getCity())
                .county(addressPostRequestBody.getCounty())
                .cep(addressPostRequestBody.getCep())
                .district(addressPostRequestBody.getDistrict())
                .users(userRepository.findById(addressPostRequestBody.getUserId())
                        .orElseThrow(() -> new NullPointerException("Not found")))
                .build();

        return addressRepository.save(address);
    }

    public List<Address> listAllAddressess() {
        return addressRepository.findAll();
    }

    @Autowired
    private ViaCEPClient viaCEPClient;


    public ViaCEP getCep(String cep) {

        return viaCEPClient.buscaPorEndereco(cep);

    }
}
