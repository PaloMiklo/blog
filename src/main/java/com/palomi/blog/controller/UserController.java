package com.palomi.blog.controller;

import com.palomi.blog.model.User;
import com.palomi.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> users() {
        return this.userRepository.findAll();
    }
}
