package com.example.secondchallenge.service;

import com.example.secondchallenge.model.UserPostRequestBody;
import com.example.secondchallenge.persistence.Users;
import com.example.secondchallenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

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

