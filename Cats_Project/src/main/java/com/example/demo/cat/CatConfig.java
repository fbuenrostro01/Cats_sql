package com.example.demo.cat;

import com.example.demo.cat.CatRepository;
import com.example.demo.cat.ShelterRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class CatConfig {
    @Bean
    CommandLineRunner commandLineRunner(
            CatRepository catRepository,
            ShelterRepository shelterRepository) {
        return args -> {
            Shelter shelter = new Shelter();
            shelter.setName("WaterValley Shelter");
            shelter.setLocation(" 420 Your dads butt street");

            Shelter savedShelter = shelterRepository.save(shelter);

            Cat whiskers = new Cat();
            whiskers.setName("Whiskers");
            whiskers.setDob(LocalDate.of(2015, Month.JANUARY, 5));
            whiskers.setShelter(savedShelter);
            catRepository.save(whiskers);
        };
    }
}