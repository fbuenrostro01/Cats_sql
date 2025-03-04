package com.example.demo.cat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AdopterConfig {

    @Bean
    CommandLineRunner adopterCommandLineRunner(AdopterRepository repository) {
        return args -> {

            repository.deleteAll();

            Adopter johnDoe = new Adopter(
                    "Faustino",
                    "Test@gmail.com"
            );

            Adopter janeDoe = new Adopter(
                    "Darwin",
                    "TestD.doe@Yahoo.com"
            );

            repository.saveAll(
                    List.of(johnDoe, janeDoe)
            );
        };
    }
}