package com.example.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    private final UserService userService;
    private final ObjectMapper objectMapper;

    @Autowired
    public UserController(UserService userService, ObjectMapper objectMapper) {
        this.userService = userService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/v1/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

    @GetMapping("/v1/users")
    public User getUserByJson(@RequestParam String json) throws IOException {
        Request userRequest = objectMapper.readValue(json, Request.class);
        return userService.getUser(userRequest.getId());
    }

}
