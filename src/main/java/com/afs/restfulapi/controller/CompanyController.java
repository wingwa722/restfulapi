package com.afs.restfulapi.controller;

import com.afs.restfulapi.dto.CompanyRequest;
import com.afs.restfulapi.dto.CompanyResponse;
import com.afs.restfulapi.entity.Company;
import com.afs.restfulapi.mapper.CompanyMapper;
import com.afs.restfulapi.service.CompanyService;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private CompanyMapper companyMapper;
    private CompanyService companyService;

    public CompanyController (CompanyMapper companyMapper, CompanyService companyService){
        this.companyMapper = companyMapper;
        this.companyService = companyService;
    }

    @GetMapping
    public List<CompanyResponse> findAllCompany(){
        return this.companyService.findAll().stream()
                .map(company -> companyMapper.toResponse(company)).collect(Collectors.toList());
    }

    // /employees/{id}
    @GetMapping("/{id")
    public Company findByID(@PathVariable Integer id){
        return this.companyService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Company createCompany(@RequestBody CompanyRequest companyRequest){
        return this.companyService.createCompany(companyMapper.toEntity(companyRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Integer id){
        this.companyService.delete(id);
    }

    @PutMapping("/{id}")
    public Company editCompany(@PathVariable Integer id, @RequestBody CompanyRequest companyRequest) {
        return this.companyService.edit(id, companyMapper.toEntity(companyRequest));
    }

    @GetMapping(params = {"page","size"})
    public PageImpl<Company> findPagingCompany(@PageableDefault Pageable pageable){
        return this.companyService.findingPageCompany(pageable);
    }

}
