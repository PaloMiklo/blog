package com.palomi.blog.db;

import com.palomi.blog.model.User;
import com.palomi.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // create mock users
        User pavol = new User("palomi", "test");
        User marek = new User("marekmi", "test");

        List<User> users = Arrays.asList(pavol, marek);
        // save to db
        this.userRepository.saveAll(users);
    }
}
