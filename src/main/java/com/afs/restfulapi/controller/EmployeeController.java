package com.afs.restfulapi.controller;

import com.afs.restfulapi.entity.Employee;
import com.afs.restfulapi.service.EmployeeService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<Employee> findAllEmployees(){
        return this.employeeService.findAll();
    }

    // /employees/{id}
    @GetMapping("/{id")
    public Employee findByID(@PathVariable Integer id){
        return this.employeeService.findById(id);
    }

    // /employees?gender=female
    @GetMapping(params = "gender")
    public List<Employee> findByGender(@RequestParam String gender){
        return this.employeeService.findByGender(gender);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeService.createEmployee(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        this.employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable Integer id, @RequestBody Employee updatedEmployee) {
        return this.employeeService.edit(id, updatedEmployee);
    }

    @GetMapping(params = {"page","size"})
    public PageImpl<Employee> findPagingEmployees(@PageableDefault Pageable pageable){
        return this.employeeService.findingPageEmployees(pageable);
    }
}


