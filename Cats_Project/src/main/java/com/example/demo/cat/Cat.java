package com.example.demo.cat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "shelter_id", nullable = false)
    @JsonBackReference
    private Shelter shelter;

    @ManyToMany
    @JoinTable(
            name = "cat_adopter",
            joinColumns = @JoinColumn(name = "cat_id"),
            inverseJoinColumns = @JoinColumn(name = "adopter_id")
    )
    private Set<Adopter> adopters;


    //settersdn and getter which i dont technically need don tthingk
    //actuall turns out i actually do need these bad bois who knew
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Shelter getShelter() {
        return shelter;
    }

    public void setShelter(Shelter shelter) {
        this.shelter = shelter;
    }

    public Set<Adopter> getAdopters() {
        return adopters;
    }

    public void setAdopters(Set<Adopter> adopters) {
        this.adopters = adopters;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                '}';
    }
}