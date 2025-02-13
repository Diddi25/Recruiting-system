package com.example.demo.repo;

import com.example.demo.model.Recruiter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface RecruiterRepo extends JpaRepository<Recruiter, Long> {

    Page<Recruiter> findByStatus(String status, Pageable pageable);
}