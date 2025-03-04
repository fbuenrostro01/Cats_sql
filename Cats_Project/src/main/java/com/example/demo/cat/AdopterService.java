package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdopterService {
    private final AdopterRepository adopterRepository;

    @Autowired
    public AdopterService(AdopterRepository adopterRepository) {
        this.adopterRepository = adopterRepository;
    }

    public List<Adopter> getAdopters() {
        return adopterRepository.findAll();
    }

    public void addNewAdopter(Adopter adopter) {
        Optional<Adopter> adopterOptional = adopterRepository
                .findAdopterByName(adopter.getName());
        if (adopterOptional.isPresent()) {
            throw new IllegalStateException("Name already registered");
        }
        adopterRepository.save(adopter);
    }

    public void deleteAdopter(Long adopterId) {
        boolean exists = adopterRepository.existsById(adopterId);
        if (!exists) {
            throw new IllegalStateException("Adopter not found with id: " + adopterId);
        }
        adopterRepository.deleteById(adopterId);
    }

    public void updateAdopter(Long adopterId, String name, String email) {
        Adopter adopter = adopterRepository.findById(adopterId)
                .orElseThrow(() -> new IllegalStateException("Adopter not found with id: " + adopterId));

        if (name != null && name.length() > 0 && !adopter.getName().equals(name)) {
            Optional<Adopter> adopterOptional = adopterRepository.findAdopterByName(name);
            if (adopterOptional.isPresent()) {
                throw new IllegalStateException("Name already taken");
            }
            adopter.setName(name);
        }

        if (email != null && email.length() > 0 && !adopter.getEmail().equals(email)) {
            adopter.setEmail(email);
        }

        adopterRepository.save(adopter);
    }
}
