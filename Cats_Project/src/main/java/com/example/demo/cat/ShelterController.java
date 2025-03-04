package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Shelter/")
public class ShelterController {
    private final ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }


    @GetMapping
    public List<Shelter> getShelters() {
        return shelterService.getShelters();
    }


    @PostMapping
    public void registerNewShelter(@RequestBody Shelter shelter) {
        shelterService.addNewShelter(shelter);
    }


    @DeleteMapping(path = "{shelterId}")
    public void deleteShelter(@PathVariable("shelterId") Long shelterId) {
        shelterService.deleteShelter(shelterId);
    }


    @PutMapping(path = "{shelterId}")
    public void updateShelter(
            @PathVariable("shelterId") Long shelterId,
            @RequestBody Shelter shelter) {
        shelterService.updateShelter(
                shelterId,
                shelter.getName(),
                shelter.getLocation()
        );
    }
}