package com.afs.restfulapi.Repository;

import com.afs.restfulapi.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCompanyRepository extends JpaRepository<Company, Integer> {
}
