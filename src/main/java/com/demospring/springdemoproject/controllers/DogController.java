package com.demospring.springdemoproject.controllers;

import com.demospring.springdemoproject.models.entity.Dog;
import com.demospring.springdemoproject.service.interfaces.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dog")
public class DogController {

    DogService dogService;

    @Autowired
    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ResponseEntity<Dog> saveDog(@RequestBody Dog dog) {

        dogService.save(dog);
        return new ResponseEntity<>(dog, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Dog> delete(@PathVariable Long id) {

        dogService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
