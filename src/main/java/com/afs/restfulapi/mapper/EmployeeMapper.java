package com.afs.restfulapi.mapper;

import com.afs.restfulapi.dto.EmployeeRequest;
import com.afs.restfulapi.dto.EmployeeResponse;
import com.afs.restfulapi.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public Employee toEntity(EmployeeRequest employeeRequest){
        Employee employee = new Employee();

        employee.setCompanyId(employeeRequest.getCompanyId());
        employee.setAge(employeeRequest.getAge());
        employee.setGender(employeeRequest.getGender());
        employee.setSalary(employeeRequest.getSalary());
        employee.setName(employeeRequest.getName());

        return employee;
    }

    public EmployeeResponse toResponse(Employee employee){
        EmployeeResponse employeeRespond = new EmployeeResponse();
        employeeRespond.setId(employee.getId());
        employeeRespond.setName(employee.getName());
        employeeRespond.setGender(employee.getGender());
        employeeRespond.setAge(employee.getAge());

        return employeeRespond;
    }
}
