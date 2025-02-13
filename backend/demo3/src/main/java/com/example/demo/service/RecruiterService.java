package com.example.demo.service;

import com.example.demo.model.Recruiter;
import com.example.demo.repo.RecruiterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepo recruiterRepo;

    public Page<Recruiter> getAllRecruiters(String sort, String order, String status, int page, int size) {
        Sort.Direction direction = order.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        PageRequest pageRequest = PageRequest.of(page - 1, size, Sort.by(direction, sort));

        if (status != null && !status.isEmpty()) {
            return recruiterRepo.findByStatus(status, pageRequest);
        } else {
            return recruiterRepo.findAll(pageRequest);
        }
    }
}