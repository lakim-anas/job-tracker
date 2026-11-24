package com.anaslakim.job_tracker;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobTrackerApplication.class, args);
	}


    @Bean
    CommandLineRunner testData(JobApplicationRepository repository) {
        return args -> {
            repository.save(new JobApplication("Travelers", "Software Engineering Intern", "Applied", LocalDate.of(2026, 11, 23)));
            repository.save(new JobApplication("Selective Insurance", "IT Intern", "Not applied", LocalDate.of(2026, 11, 23)));

            System.out.println("===== Saved applications: " + repository.count() + " =====");
            repository.findAll().forEach(System.out::println);
        };
	}
}	


