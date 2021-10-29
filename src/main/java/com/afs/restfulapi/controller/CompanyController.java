package com.afs.restfulapi.controller;

import com.afs.restfulapi.entity.Company;
import com.afs.restfulapi.service.CompanyService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyService companyService;

    public CompanyController (CompanyService companyService){
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> findAllCompany(){
        return this.companyService.findAll();
    }

    // /employees/{id}
    @GetMapping("/{id")
    public Company findByID(@PathVariable Integer id){
        return this.companyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody Company company){
        return this.companyService.createCompany(company);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        this.companyService.delete(id);
    }

    @PutMapping("/{id}")
    public Company editCompany(@PathVariable Integer id, @RequestBody Company updatedCompany) {
        return this.companyService.edit(id, updatedCompany);
    }

    @GetMapping(params = {"page","size"})
    public PageImpl<Company> findPagingCompany(@PageableDefault Pageable pageable){
        return this.companyService.findingPageCompany(pageable);
    }

}
