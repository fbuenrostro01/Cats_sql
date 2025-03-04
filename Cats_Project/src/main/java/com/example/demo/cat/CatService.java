package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CatService {
    private final CatRepository catRepository;

    @Autowired
    public CatService(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    public List<Cat> getCats() {
        return catRepository.findAll();
    }

    public void addNewCat(Cat cat) {
        Optional<Cat> catOptional = catRepository
                .findCatByName(cat.getName());
        if (catOptional.isPresent()) {
            throw new IllegalStateException("Cat with this name already exists");
        }
        if (cat.getShelter() == null) {
            throw new IllegalStateException("Cat must be assigned to a shelter");
        }
        catRepository.save(cat);
    }

    public void deleteCat(Long catId) {
        boolean exists = catRepository.existsById(catId);
        if (!exists) {
            throw new IllegalStateException("Cat not found with id: " + catId);
        }
        catRepository.deleteById(catId);
    }

    public void updateCat(Long catId, String name, LocalDate dob, Shelter shelter) {
        Cat cat = catRepository.findById(catId)
                .orElseThrow(() -> new IllegalStateException("Cat not found with id: " + catId));

        if (name != null && name.length() > 0 && !cat.getName().equals(name)) {
            Optional<Cat> catOptional = catRepository.findCatByName(name);
            if (catOptional.isPresent()) {
                throw new IllegalStateException("Name already taken");
            }
            cat.setName(name);
        }

        if (dob != null && !cat.getDob().equals(dob)) {
            cat.setDob(dob);
        }

        catRepository.save(cat);
    }


}
