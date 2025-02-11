package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String competenceAreas; // Competence areas (e.g., "Java, Spring Boot")
    private int yearsOfExperience;  // Years of experience
    private LocalDate availabilityFrom; // Availability start date
    private LocalDate availabilityTo;   // Availability end date

    @Column(nullable = false) // Ensure this field is not null
    private LocalDate applicationDate; // New field for application date

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompetenceAreas() {
        return competenceAreas;
    }

    public void setCompetenceAreas(String competenceAreas) {
        this.competenceAreas = competenceAreas;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public LocalDate getAvailabilityFrom() {
        return availabilityFrom;
    }

    public void setAvailabilityFrom(LocalDate availabilityFrom) {
        this.availabilityFrom = availabilityFrom;
    }

    public LocalDate getAvailabilityTo() {
        return availabilityTo;
    }

    public void setAvailabilityTo(LocalDate availabilityTo) {
        this.availabilityTo = availabilityTo;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }
}