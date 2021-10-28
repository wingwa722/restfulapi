package com.afs.restfulapi;

import com.afs.restfulapi.Exception.CompanyNotFoundException;
import com.afs.restfulapi.Repository.NewCompanyRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {
    private final NewCompanyRepository newCompanyRepository;
    //@Controller
    //@Service
    //@Repository
    //@Component


    public CompanyService(NewCompanyRepository newCompanyRepository){
        this.newCompanyRepository = newCompanyRepository;
    }

    public List<Company> findAll() {
        return this.newCompanyRepository.findAll();
    }

    public Company findById(Integer id) {
        return this.newCompanyRepository.findById(id).orElseThrow(CompanyNotFoundException::new);
    }

    public Company edit(Integer id, Company updatedCompany) {
        Company originCompany = findById(id);
        if (updatedCompany.getCompanyName() != null) {
            originCompany.setCompanyName(updatedCompany.getCompanyName());
        }
        if (updatedCompany.getEmployees() != null) {
            originCompany.setEmployees(updatedCompany.getEmployees());
        }
        return this.newCompanyRepository.save(originCompany);
    }

    public void delete(Integer id){
        Company company = this.findById(id);
        this.newCompanyRepository.delete(company);
        //this.newCompanyRepository.deleteById(id);
    }

    public Company createCompany(Company company){
        return this.newCompanyRepository.save(company);
    }

    public PageImpl<Company> findingPageCompany(Pageable pageable){
        return null;
    }
}
