package com.afs.restfulapi.repository;

import com.afs.restfulapi.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCompanyRepository extends JpaRepository<Company, Integer> {
}
