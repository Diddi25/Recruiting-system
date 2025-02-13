package com.example.demo.controller;

import com.example.demo.model.Application;
import com.example.demo.repo.ApplicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {

    @Autowired
    private ApplicationRepo applicationRepo;

    @PostMapping
    public ResponseEntity<?> createApplication(@RequestBody Application application) {
        try {
            // Set the application date to the current date
            application.setApplicationDate(LocalDate.now());

            // Save the application
            Application savedApplication = applicationRepo.save(application);

            // Create the Location header
            URI location = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(savedApplication.getId())
                    .toUri();

            // Return the response with the Location header and application ID
            return ResponseEntity.created(location).body(savedApplication);
        } catch (ObjectOptimisticLockingFailureException e) {
            // Handle concurrent modification
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("The application was modified by another transaction. Please try again.");
        }
    }
}