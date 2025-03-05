package com.example.demo.cat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "Cat/")
public class CatController {
    private final CatService catService;

    @Autowired
    public CatController(CatService catService) {
        this.catService = catService;
    }


        @GetMapping
    public List<Cat> getCats() {
        return catService.getCats();
    }

    @PostMapping
    public void registerNewCat(@RequestBody Cat cat) {
        catService.addNewCat(cat);
    }

    @DeleteMapping(path = "{catId}")
    public void deleteCat(@PathVariable("catId") Long catId) {
        catService.deleteCat(catId);
    }

    @PutMapping(path = "{catId}")
    public void updateCat(
            @PathVariable("catId") Long catId,
            @RequestBody Cat cat) {
        catService.updateCat(
                catId,
                cat.getName(),
                cat.getDob(),
                cat.getShelter()
        );
    }
}