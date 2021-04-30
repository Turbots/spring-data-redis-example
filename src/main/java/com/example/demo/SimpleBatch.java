package com.example.demo;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimpleBatch {

    private static final Logger log = LoggerFactory.getLogger(SimpleBatch.class);

    private final EmployeeRepository repo;

    public SimpleBatch(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Scheduled(initialDelay = 1000, fixedRate = 5000)
    public void addRecord() {
        Employee emp = new Employee();
        emp.setName(UUID.randomUUID().toString());

        log.info("Storing Employee " + emp.getName());
        this.repo.save(emp);
    }
}
