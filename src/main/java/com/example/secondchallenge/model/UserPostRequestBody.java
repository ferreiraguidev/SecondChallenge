package com.example.secondchallenge.model;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class UserPostRequestBody {

    @NotBlank
    private String name;

    @NotBlank
    private String userEmail;

    @NotNull
    private Long cpf;


    @NotNull
    private LocalDate birth;

}
