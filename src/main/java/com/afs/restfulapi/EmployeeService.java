package com.afs.restfulapi;

import com.afs.restfulapi.Repository.EmployeeRepository;
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

    public Employee findById(Integer id) {
        return this.employeeRepository.findById(id);
    }

    public Employee edit(Integer id, Employee updatedEmployee) {
        Employee originEmployee = this.employeeRepository.findById(id);
        if (updatedEmployee.getAge() != null) {
            originEmployee.setAge(updatedEmployee.getAge());
        }
        if (updatedEmployee.getSalary() != null) {
            originEmployee.setSalary(updatedEmployee.getSalary());
        }
        return this.employeeRepository.save(id, originEmployee);
    }
}
