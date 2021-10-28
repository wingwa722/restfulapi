package com.afs.restfulapi;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String companyName;
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "companyId")
    List<Employee> employees;

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
