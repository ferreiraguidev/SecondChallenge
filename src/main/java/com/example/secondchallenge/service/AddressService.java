package com.example.secondchallenge.service;


import com.example.secondchallenge.model.AddressPostRequestBody;
import com.example.secondchallenge.persistence.Address;
import com.example.secondchallenge.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(AddressPostRequestBody addressPostRequestBody) {
        Address address = Address.builder()
                .logadouro(addressPostRequestBody.getLogadouro())
                .number(addressPostRequestBody.getNumber())
                .city(addressPostRequestBody.getCity())
                .county(addressPostRequestBody.getCounty())
                .CEP(addressPostRequestBody.getCEP())
                .build();

        return addressRepository.save(address);

    }

    public List<Address> listAllAddressess() {
        return addressRepository.findAll();
    }


}
