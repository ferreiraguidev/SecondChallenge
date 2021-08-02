package com.example.secondchallenge.service;

import com.example.secondchallenge.model.UserPostRequestBody;
import com.example.secondchallenge.persistence.Address;
import com.example.secondchallenge.persistence.Users;
import com.example.secondchallenge.repository.AddressRepository;
import com.example.secondchallenge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AddressRepository addressRepository;

    public Users save(UserPostRequestBody userPostRequestBody) {

        Users users = Users.builder()
                .name(userPostRequestBody.getName())
                .userEmail(userPostRequestBody.getUserEmail())
                .cpf(userPostRequestBody.getCpf())
                .birth(userPostRequestBody.getBirth())
                .build();

        return userRepository.save(users);

    }

    public List<Users> ListAllUsers(){
        return userRepository.findAll();
    }

}

