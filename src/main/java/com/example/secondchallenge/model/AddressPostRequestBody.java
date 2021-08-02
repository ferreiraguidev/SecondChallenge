package com.example.secondchallenge.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class AddressPostRequestBody {

    @NotNull
    private Long logadouro;
    @NotNull
    private Long number;
    @NotNull
    private Long CEP;

    @NotBlank
    private String city;

    @NotBlank
    private String county;

    @NotNull
    private Long userId;

}
