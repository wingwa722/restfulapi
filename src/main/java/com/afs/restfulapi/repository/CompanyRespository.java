package com.afs.restfulapi.repository;

import com.afs.restfulapi.entity.Company;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CompanyRespository {
    private final List<Company> companies = new ArrayList<>();

    public List<Company> findAll() {
        return companies;
    }
}
