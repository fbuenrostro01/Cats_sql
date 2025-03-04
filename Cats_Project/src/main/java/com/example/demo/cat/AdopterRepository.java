package com.example.demo.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdopterRepository
        extends JpaRepository<Adopter, Long> {

    @Query("SELECT a FROM Adopter a WHERE a.name = ?1")
    Optional<Adopter> findAdopterByName(String name);




}