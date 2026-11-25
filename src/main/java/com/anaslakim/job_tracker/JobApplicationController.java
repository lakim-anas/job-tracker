package com.anaslakim.job_tracker;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public JobApplication addApplication(@RequestBody JobApplication application) {
        return repository.save(application);
    }
        @GetMapping("/applications/{id}")
    public JobApplication getApplicationById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @DeleteMapping("/applications/{id}")
    public void deleteApplication(@PathVariable Long id) {
        repository.deleteById(id);
    }
}