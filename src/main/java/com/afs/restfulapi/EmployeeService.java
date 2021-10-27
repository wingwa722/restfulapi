package com.afs.restfulapi;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    //@Controller
    //@Service
    //@Repository
    //@Component


    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }
}
