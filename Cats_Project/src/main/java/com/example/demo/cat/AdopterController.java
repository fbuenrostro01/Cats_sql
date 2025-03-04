package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Adopter/")
public class AdopterController {
    private final AdopterService adopterService;

    @Autowired
    public AdopterController(AdopterService adopterService) {
        this.adopterService = adopterService;
    }

    @GetMapping
    public List<Adopter> getAdopters() {
        return adopterService.getAdopters();
    }

    @PostMapping
    public void registerNewAdopter(@RequestBody Adopter adopter) {
        adopterService.addNewAdopter(adopter);
    }

    @DeleteMapping(path = "{adopterId}")
    public void deleteAdopter(@PathVariable("adopterId") Long adopterId) {
        adopterService.deleteAdopter(adopterId);
    }

    @PutMapping(path = "{adopterId}")
    public void updateAdopter(
            @PathVariable("adopterId") Long adopterId,
            @RequestBody Adopter adopter) {
        adopterService.updateAdopter(
                adopterId,
                adopter.getName(),
                adopter.getEmail()

        );

    }
}