package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



    public User insert(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Integer idx) {
        return userRepository.findById(idx);
    }
}
