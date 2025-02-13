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
public class Recruiter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Namn på rekryteraren
    private String status; // Status för rekryteraren (t.ex. active, inactive)

    private String competenceAreas; // Kompetensområden (t.ex. "Java, Spring Boot")
    private int yearsOfExperience;  // År av erfarenhet
    private LocalDate availabilityFrom; // Tillgänglighet från datum
    private LocalDate availabilityTo;   // Tillgänglighet till datum

    @Column(nullable = false) // Säkerställ att detta fält inte är null
    private LocalDate applicationDate; // Datum för rekryterarens ansökan

    // Getters och setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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