package com.afs.restfulapi;

import com.afs.restfulapi.Exception.EmployeeNotFoundException;
import com.afs.restfulapi.Repository.EmployeeRepository;
import com.afs.restfulapi.Repository.NewEmployeeRepository;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final NewEmployeeRepository newEmployeeRepository;
    //@Controller
    //@Service
    //@Repository
    //@Component


    public EmployeeService(EmployeeRepository employeeRepository, NewEmployeeRepository newEmployeeRepository){
        this.employeeRepository = employeeRepository;
        this.newEmployeeRepository = newEmployeeRepository;
    }

    public List<Employee> findAll() {
        return this.newEmployeeRepository.findAll();
    }

    public Employee findById(Integer id) {
        return this.newEmployeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }

    public List<Employee> findByGender(String gender) {
        return this.newEmployeeRepository.findAllByGender(gender);
    }

    public Employee edit(Integer id, Employee updatedEmployee) {
        Employee originEmployee = findById(id);
        if (updatedEmployee.getAge() != null) {
            originEmployee.setAge(updatedEmployee.getAge());
        }
        if (updatedEmployee.getGender() != null) {
            originEmployee.setSalary(updatedEmployee.getSalary());
        }
        if (updatedEmployee.getName() != null) {
            originEmployee.setName(updatedEmployee.getName());
        }
        if (updatedEmployee.getSalary() != null) {
            originEmployee.setSalary(updatedEmployee.getSalary());
        }
        return this.newEmployeeRepository.save(originEmployee);
    }

    public void delete(Integer id){
        Employee employee = this.findById(id);
        this.newEmployeeRepository.delete(employee);
        //this.newEmployeeRepository.deleteById(id);
    }

    public Employee createEmployee(Employee employee){
        return this.newEmployeeRepository.save(employee);
    }

   public PageImpl<Employee> findingPageEmployees(Pageable pageable){
        return null;
   }
}
