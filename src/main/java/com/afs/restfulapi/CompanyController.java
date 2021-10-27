package com.afs.restfulapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Companies")
public class CompanyController {
    public final CompanyRespository companyRespository;

    public CompanyController (CompanyRespository companyRespository){
        this.companyRespository = companyRespository;
    }

    @GetMapping
    public List<Company> findAllCompany(){
        return this.companyRespository.findAll();
    }
}
