package com.afs.restfulapi;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

public class EmployeeServiceTest {
    @Test
    void should_return_all_employees_when_find_all_given_2_employees() {
        //given
        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
        EmployeeService employeeService = new EmployeeService(employeeRepository);
        List<Employee> expected = Arrays.asList(new Employee(1, "Wing", 22, "Female", 101));
        when(employeeRepository.findAll()).thenReturn(expected);

        //when
        List<Employee> actual = employeeService.findAll();

        //given
        assertEquals(expected, actual);
    }

    @Test
    void should_return_employee_1_when_find_by_id_1_given_employee1() {

    }
}
