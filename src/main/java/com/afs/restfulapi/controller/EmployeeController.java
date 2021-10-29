package com.afs.restfulapi.controller;

import com.afs.restfulapi.dto.EmployeeRequest;
import com.afs.restfulapi.entity.Employee;
import com.afs.restfulapi.mapper.EmployeeMapper;
import com.afs.restfulapi.dto.EmployeeResponse;
import com.afs.restfulapi.service.EmployeeService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeMapper employeeMapper;
    private EmployeeService employeeService;

    public EmployeeController(EmployeeMapper employeeMapper, EmployeeService employeeService){
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<EmployeeResponse> findAllEmployees(){
        return this.employeeService.findAll().stream()
                .map(employee -> employeeMapper.toResponse(employee)).collect(Collectors.toList());
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
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest){
        return this.employeeService.createEmployee(employeeMapper.toEntity(employeeRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        this.employeeService.delete(id);
    }

    @PutMapping("/{id}")
    public Employee editEmployee(@PathVariable Integer id, @RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.edit(id, employeeMapper.toEntity(employeeRequest));
    }

    @GetMapping(params = {"page","size"})
    public PageImpl<Employee> findPagingEmployees(@PageableDefault Pageable pageable){
        return this.employeeService.findingPageEmployees(pageable);
    }
}


