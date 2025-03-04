package com.example.demo.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShelterRepository
        extends JpaRepository<Shelter, Long> {

    @Query("SELECT s FROM Shelter s WHERE s.name = ?1")
    Optional<Shelter> findShelterByName(String name);




}