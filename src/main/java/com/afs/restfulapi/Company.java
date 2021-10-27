package com.afs.restfulapi;

import java.util.List;

public class Company {
    private String companyName;
    private List<Employee> employeeList;

    public Company(String companyName,List<Employee> employeeList){
        this.companyName = companyName;
        this.employeeList = employeeList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

}
