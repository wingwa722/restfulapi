package com.afs.restfulapi.Repository;

import com.afs.restfulapi.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NewEmployeeRepository extends JpaRepository<Employee, Integer> {
    List<Employee> findAllByGender(String gender);
}
