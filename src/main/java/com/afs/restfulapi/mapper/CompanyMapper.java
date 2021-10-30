package com.afs.restfulapi.mapper;

import com.afs.restfulapi.dto.CompanyRequest;
import com.afs.restfulapi.dto.CompanyResponse;
import com.afs.restfulapi.dto.EmployeeRequest;
import com.afs.restfulapi.dto.EmployeeResponse;
import com.afs.restfulapi.entity.Company;
import com.afs.restfulapi.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper {
    public Company toEntity(CompanyRequest companyRequest) {
        Company company = new Company();

        company.setCompanyName(companyRequest.getName());

        return company;
    }

    public CompanyResponse toResponse(Company company){
        CompanyResponse companyRespond = new CompanyResponse();
        companyRespond.setName(company.getCompanyName());

        return companyRespond;
    }
}

