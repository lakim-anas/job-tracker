package com.anaslakim.job_tracker;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}