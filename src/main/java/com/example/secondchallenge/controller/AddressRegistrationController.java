package com.example.secondchallenge.controller;

import com.example.secondchallenge.model.AddressPostRequestBody;
import com.example.secondchallenge.persistence.Address;
import com.example.secondchallenge.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AddressRegistrationController {

    private final AddressService addressService;

    public AddressRegistrationController(AddressService addressService) {
        this.addressService = addressService;
    }


    @GetMapping("/address")
    @ResponseStatus(HttpStatus.OK)
    public List<Address> listAll() {
        return addressService.listAllAddressess();
    }

    @PostMapping("/address")
    public ResponseEntity<Address> save(@RequestBody AddressPostRequestBody addressPostRequestBody) {
        return new ResponseEntity<>(addressService.save(addressPostRequestBody), HttpStatus.CREATED);
    }
}
