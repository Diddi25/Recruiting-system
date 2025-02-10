package com.example.demo.model;
import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // Primary key

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "person_number", nullable = false, unique = true)
    private String personNumber;

    @Column(name = "email", nullable = true, unique = true)
    private String email;

    @Column(name = "availability_periods", columnDefinition = "TEXT[]")
    private List<String> availabilityPeriods; // Maps to PostgreSQL TEXT[]

    @Column(name = "competences", columnDefinition = "TEXT[]")
    private List<String> competences; // Maps to PostgreSQL TEXT[]

    // Default constructor
    public Person() {
    }

    // Constructor with all fields
    public Person(String firstName, String lastName, String personNumber, String email, List<String> availabilityPeriods, List<String> competences) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personNumber = personNumber;
        this.email = email;
        this.availabilityPeriods = availabilityPeriods;
        this.competences = competences;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    // Getter and Setter for firstName
    public String getFirstName() {
        return this.firstName != null ? this.firstName.toUpperCase() : null;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for lastName
    public String getLastName() {
        return this.lastName != null ? this.lastName.toUpperCase() : null;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for personNumber
    public String getPersonNumber() {
        return personNumber;
    }

    public void setPersonNumber(String personNumber) {
        this.personNumber = personNumber;
    }

    // Getter and Setter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for availabilityPeriods
    public List<String> getAvailabilityPeriods() {
        return availabilityPeriods;
    }

    public void setAvailabilityPeriods(List<String> availabilityPeriods) {
        this.availabilityPeriods = availabilityPeriods;
    }

    // Getter and Setter for competences
    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    } 
}