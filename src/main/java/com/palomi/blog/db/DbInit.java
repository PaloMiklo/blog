package com.palomi.blog.db;

import com.palomi.blog.model.User;
import com.palomi.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void run(String... args) throws Exception {
        // delete all
        this.userRepository.deleteAll();

        // create mock users
        User pavol = new User("palomi", passwordEncoder.encode("test"), "USER","");
        User marek = new User("marekmi", passwordEncoder.encode("test"), "ADMIN","ACCESS_TEST1,ACCESS_TEST2");

        List<User> users = Arrays.asList(pavol, marek);
        // save to db
        this.userRepository.saveAll(users);
    }
}
