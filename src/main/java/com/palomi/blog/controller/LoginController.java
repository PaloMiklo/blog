package com.palomi.blog.controller;

import com.palomi.blog.model.User;
import com.palomi.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @PostMapping("/signup")
    public ResponseEntity<Object> signUp(@org.jetbrains.annotations.NotNull @RequestBody User user) {
        User userExists = userRepository.findByUsername(user.getUsername());
        if (userExists == null) {
            User newUser = new User(user.getUsername(), passwordEncoder.encode(user.getPassword()));
            userRepository.save(newUser);
            return ResponseEntity.ok("User created!");
        }
        return new ResponseEntity<Object>(
                "User with username " + userExists.getUsername() + " already exists - choose another username!", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@org.jetbrains.annotations.NotNull @RequestBody User user) {
        User userExists = userRepository.findByUsername(user.getUsername());
        if (userExists == null) {
            return new ResponseEntity<Object>(
                    "Wrong username!", new HttpHeaders(), HttpStatus.FORBIDDEN);
        }
        String userPassword = userExists.getPassword();
        if (userExists != null && passwordEncoder.matches(user.getPassword(), userPassword)) {
            // sent token
            return ResponseEntity.ok("User logged in!");
        }
        return new ResponseEntity<Object>(
                "Wrong credentias!", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

}
