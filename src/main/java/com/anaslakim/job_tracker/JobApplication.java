package com.anaslakim.job_tracker;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
@Entity
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Company is required")
    private String company;
    @NotBlank(message = "Role is required")
    private String role;
    @NotBlank(message = "Status is required")
    private String status;
    @NotNull(message = "Date applied is required")
    private LocalDate dateApplied;

    // Empty constructor: JPA needs this
    public JobApplication() {
    }

    // Constructor we use to create new applications
    public JobApplication(String company, String role, String status, LocalDate dateApplied) {
        this.company = company;
        this.role = role;
        this.status = status;
        this.dateApplied = dateApplied;
    }

    // Getters and setters
    public Long getId() { return id; }

    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getDateApplied() { return dateApplied; }
    public void setDateApplied(LocalDate dateApplied) { this.dateApplied = dateApplied; }

    @Override
    public String toString() {
        return id + " | " + company + " | " + role + " | " + status + " | " + dateApplied;
    }
}
    

