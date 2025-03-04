package com.example.demo.cat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ShelterConfig {
    @Bean
    CommandLineRunner shelterCommandLineRunner(
            ShelterRepository repository) {
        return args -> {
            Shelter happyPaws = new Shelter(
                    "Vardaman Shelter",
                    "122 Your Moms Butt Street"
            );
            repository.saveAll(
                    List.of(happyPaws)
            );
        };
    }
}