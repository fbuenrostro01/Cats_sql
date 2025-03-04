package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShelterService {
    private final ShelterRepository shelterRepository;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public List<Shelter> getShelters() {
        return shelterRepository.findAll();
    }

    public void addNewShelter(Shelter shelter) {
        Optional<Shelter> shelterOptional = shelterRepository
                .findShelterByName(shelter.getName());
        if (shelterOptional.isPresent()) {
            throw new IllegalStateException("Shelter with this name already exists");
        }
        if (shelter.getLocation() == null || shelter.getLocation().isEmpty()) {
            throw new IllegalStateException("Shelter must have a location");
        }
        shelterRepository.save(shelter);
    }

    public void deleteShelter(Long shelterId) {
        boolean exists = shelterRepository.existsById(shelterId);
        if (!exists) {
            throw new IllegalStateException("Shelter not found with id: " + shelterId);
        }
        shelterRepository.deleteById(shelterId);
    }

    public void updateShelter(Long shelterId, String name, String location) {
        Shelter shelter = shelterRepository.findById(shelterId)
                .orElseThrow(() -> new IllegalStateException("Shelter not found with id: " + shelterId));

        if (name != null && name.length() > 0 && !shelter.getName().equals(name)) {
            Optional<Shelter> shelterOptional = shelterRepository.findShelterByName(name);
            if (shelterOptional.isPresent()) {
                throw new IllegalStateException("Shelter name already taken");
            }
            shelter.setName(name);
        }

        if (location != null && location.length() > 0 && !shelter.getLocation().equals(location)) {
            shelter.setLocation(location);
        }

        shelterRepository.save(shelter);
    }
}