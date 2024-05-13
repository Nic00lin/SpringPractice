package com.example.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserImplService implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(int id) {

        return userRepository.findById(id).orElse(null);
    }
}