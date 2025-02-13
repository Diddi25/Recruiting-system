package com.example.demo.controller;

import com.example.demo.model.Recruiter;
import com.example.demo.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recruiters")
public class RecruiterController {

    @Autowired
    private RecruiterService recruiterService; // Använd RecruiterService här

    @GetMapping
    public ResponseEntity<Page<Recruiter>> getAllRecruiters(
            @RequestParam(required = false) String sort,
            @RequestParam(required = false, defaultValue = "asc") String order,
            @RequestParam(required = false) String status,
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {

        Page<Recruiter> recruiters = recruiterService.getAllRecruiters(sort, order, status, page, size);
        return ResponseEntity.ok(recruiters);
    }
}