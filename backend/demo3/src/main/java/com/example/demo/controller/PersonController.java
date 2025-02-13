package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Person;
import com.example.demo.repo.PersonRepo;

@RestController
public class PersonController {

    @Autowired
    private PersonRepo repo;

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        if (person.getFirstName() == null) {
            return ResponseEntity.badRequest().body(null); // Return 400 if name is null
        }
        Person savedPerson = repo.save(person);
        return ResponseEntity.ok(savedPerson);
    }
}