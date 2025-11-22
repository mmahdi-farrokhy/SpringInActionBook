package com.example.authorizationserver;

import com.example.authorizationserver.tacos.data.User;
import com.example.authorizationserver.tacos.data.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }


    @Bean
    public ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            User userHabuma = new User("habuma", encoder.encode("password"), "ROLE_ADMIN");
            User userTacochef = new User("tacochef", encoder.encode("password"), "ROLE_ADMIN");
            repo.save(userHabuma);
            repo.save(userTacochef);
        };
    }
}
