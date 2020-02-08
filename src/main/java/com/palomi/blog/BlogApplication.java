package com.palomi.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


// temporary to disable 401 (and generating security code in console after start up) till I'll set up security
// (exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
