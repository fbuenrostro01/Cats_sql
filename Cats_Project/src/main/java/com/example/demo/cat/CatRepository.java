package com.example.demo.cat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {

    @Query("SELECT c FROM Cat c WHERE c.name = ?1")

    Optional<Cat> findCatByName(String name);
}