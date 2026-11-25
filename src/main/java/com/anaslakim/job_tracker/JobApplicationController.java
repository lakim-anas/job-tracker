package com.anaslakim.job_tracker;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;
@RestController
public class JobApplicationController {

    private final JobApplicationRepository repository;

    public JobApplicationController(JobApplicationRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/applications")
    public List<JobApplication> getAllApplications() {
        return repository.findAll();
    }

    @PostMapping("/applications")
    public ResponseEntity<JobApplication> addApplication(@Valid @RequestBody JobApplication application) {
        JobApplication saved = repository.save(application);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping("/applications/{id}")
    public ResponseEntity<JobApplication> getApplicationById(@PathVariable Long id) {
        JobApplication found = repository.findById(id).orElse(null);
        if (found == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(found);
    }

    @PutMapping("/applications/{id}")
    public ResponseEntity<JobApplication> updateApplication(@PathVariable Long id, @Valid@RequestBody JobApplication updated) {
        JobApplication existing = repository.findById(id).orElse(null);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        existing.setCompany(updated.getCompany());
        existing.setRole(updated.getRole());
        existing.setStatus(updated.getStatus());
        existing.setDateApplied(updated.getDateApplied());
        return ResponseEntity.ok(repository.save(existing));
    }

    @DeleteMapping("/applications/{id}")
    public ResponseEntity<Void> deleteApplication(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}