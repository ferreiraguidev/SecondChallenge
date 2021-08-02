package com.example.secondchallenge.service;


import com.example.secondchallenge.model.AddressPostRequestBody;
import com.example.secondchallenge.persistence.Address;
import com.example.secondchallenge.repository.AddressRepository;
import com.example.secondchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {


    @Autowired
    AddressRepository addressRepository;

    @Autowired
    UserRepository userRepository;

    public Address save(AddressPostRequestBody addressPostRequestBody) {
        Address address = Address.builder()
                .logadouro(addressPostRequestBody.getLogadouro())
                .number(addressPostRequestBody.getNumber())
                .city(addressPostRequestBody.getCity())
                .county(addressPostRequestBody.getCounty())
                .CEP(addressPostRequestBody.getCEP())
                .users(userRepository.findById(addressPostRequestBody.getUserId())
                        .orElseThrow(() -> new NullPointerException("Not found")))
                .build();

        return addressRepository.save(address);

    }

    public List<Address> listAllAddressess() {
        return addressRepository.findAll();
    }

}
