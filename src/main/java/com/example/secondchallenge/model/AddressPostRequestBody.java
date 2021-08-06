package com.example.secondchallenge.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressPostRequestBody {

    @NotNull
    private String logradouro;

    @NotNull
    private String number;

    @NotNull
    private String cep;

    @NotBlank
    private String city;

    @NotBlank
    private String county;

    @NotNull
    private String district;

    @NotNull
    private Long userId;

}
