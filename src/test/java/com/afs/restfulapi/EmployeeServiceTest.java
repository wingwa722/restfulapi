package com.afs.restfulapi;

import com.afs.restfulapi.entity.Employee;
import com.afs.restfulapi.repository.NewEmployeeRepository;
import com.afs.restfulapi.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {
    @Mock
    private NewEmployeeRepository employeeRepository;

//    @Mock
//    private newEmployeeRepository newEmployeeRepository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void should_return_all_employees_when_find_all_given_2x_employees() {
        //given
        List<Employee> expected = Arrays.asList(new Employee(1, "Wing", 22, "Female", 101));
        when(employeeRepository.findAll()).thenReturn(expected);

        //when
        List<Employee> actual = employeeService.findAll();

        //then
        assertEquals(expected, actual);
    }

    @Test
    void should_return_employee_1_when_find_by_id_1_given_employee1() {
        //given
        Employee expected = new Employee(1, "Wing", 22, "Female", 101);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(expected));

        //when
        Employee actual = employeeService.findById(1);

        //then
        assertEquals(expected, actual);

    }

    @Test
    void should_return_updated_employee_when_edit_employee_given_employee_update_info() {
        //given
        Employee employee = new Employee(1, "Wing", 22, "Female", 101);
        when(employeeRepository.findById(1)).thenReturn(Optional.of(employee));
        when(employeeRepository.save(any(Employee.class)))
                .then(invocation -> invocation.getArgument(0));

        Employee updateInfo = new Employee(null, null, null, 999999);

        //when
        Employee actual = employeeService.edit(1, updateInfo);

        //then
        assertEquals("Wing", actual.getName());
        assertEquals(22, actual.getAge());
        assertEquals(999999, actual.getSalary());
        assertEquals("Female", actual.getGender());
    }

    @Test
    void should_return_employee_when_add_employee_given_employee() {
        //given
        Employee expected = new Employee(1, "Wing", 22, "Female", 101);
        when(employeeRepository.save(expected)).thenReturn(expected);

        //given
        Employee actual = employeeService.createEmployee(expected);

        //then
        assertEquals(expected, actual);
    }
}
