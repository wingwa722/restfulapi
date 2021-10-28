package com.afs.restfulapi.Controller;

import com.afs.restfulapi.Employee;
import com.afs.restfulapi.EmployeeService;
import com.afs.restfulapi.Repository.EmployeeRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeRepository employeeRepository, EmployeeService employeeService){
        this.employeeRepository = employeeRepository;
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> findAllEmployees(){
        return this.employeeService.findAll();
    }

    // /employees/{id}
    @GetMapping("/{id")
    public Employee findByID(@PathVariable Integer id){
        return this.employeeRepository.findById(id);
    }

    // /employees?gender=female
    @GetMapping(params = "gender")
    public List<Employee> findByGender(@RequestParam String gender){
        return this.employeeRepository.findByGender(gender);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeRepository.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        this.employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        Employee originEmployee = this.employeeRepository.findById(id);
        if (updatedEmployee.getAge() != null) {
            originEmployee.setAge(updatedEmployee.getAge());
        }
        if (updatedEmployee.getSalary() != null) {
            originEmployee.setSalary(updatedEmployee.getSalary());
        }
        return this.employeeRepository.save(id, originEmployee);
    }

        @GetMapping(params = {"page","size"})
                public PageImpl<Employee> findPagingEmployees(@PageableDefault Pageable pageable){
            return this.employeeRepository.findPagingEmployees(pageable);
        }
    }


