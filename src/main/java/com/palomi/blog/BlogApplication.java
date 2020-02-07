package com.palomi.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



// temporary to disable generating security code in console after start up till I set up auth
// (exclude = {SecurityAutoConfiguration.class })
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);
    }

}
