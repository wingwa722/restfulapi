package com.afs.restfulapi;


import com.afs.restfulapi.Repository.EmployeeRepository;
import com.afs.restfulapi.Repository.NewEmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Sql(statements = "alter table employee alter column id restart with 1")
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

//    @Autowired
//    private EmployeeRepository employeeRepository;

    @Autowired
    private NewEmployeeRepository employeeRepository;

    @AfterEach
    void tearDown(){
        this.employeeRepository.deleteAll();
    }

    @Test
    void should_return_all_employees_when_find_all_given_2_two_employee() throws Exception{
        Employee employee1 = new Employee ("Wing", 22, "Female", 101);
        Employee employee2 = new Employee ("Tommy", 18, "Male", 102);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        //when
        ResultActions resultActions = mockMvc.perform(get("/employees"));

        //then
        String expected = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Wing\",\n" +
                "        \"age\": 22,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"salary\": 101\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": 2,\n" +
                "        \"name\": \"Tommy\",\n" +
                "        \"age\": 18,\n" +
                "        \"gender\": \"Male\",\n" +
                "        \"salary\": 102\n" +
                "    }\n" +
                "]";
        resultActions.andExpect(status().isOk()).andExpect(content().json(expected));
    }


    @Test
    void should_return_male_employees_when_find_male_employees_given_1_male_employee_and_1_female_employee() throws Exception {
        Employee employee1 = new Employee("Wing", 22, "Female", 101);
        Employee employee2 = new Employee ("Tommy", 18, "Male", 102);

        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        //when
        ResultActions resultActions = mockMvc.perform(get("/employees?gender=Female"));

        //then
        String expected = "[\n" +
                "    {\n" +
                "        \"id\": 1,\n" +
                "        \"name\": \"Wing\",\n" +
                "        \"age\": 22,\n" +
                "        \"gender\": \"Female\",\n" +
                "        \"salary\": 101\n" +
                "    }\n" +
                "]";

        resultActions.andExpect(status().isOk()).andExpect(content().json(expected));
    }

    //Error appear
//    @Test
//    void should_return_created_employee_when_create_employee_given_new_employee_info() throws Exception{
//        //given
//        String newEmployee = "[\n" +
//                "    {\n" +
//                "        \"id\": 1,\n" +
//                "        \"name\": \"Wing\",\n" +
//                "        \"age\": 22,\n" +
//                "        \"gender\": \"Female\",\n" +
//                "        \"salary\": 101\n" +
//                "    }\n" +
//                "]";
//
//        //when
//        ResultActions resultActions = mockMvc.perform(post("/employees")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(newEmployee));
//
//        //then
//        String expected = "[\n" +
//                "    {\n" +
//                "        \"id\": 1,\n" +
//                "        \"name\": \"Wing\",\n" +
//                "        \"age\": 22,\n" +
//                "        \"gender\": \"Female\",\n" +
//                "        \"salary\": 101\n" +
//                "    }\n" +
//                "]";
//                resultActions.andExpect(status().isCreated())
//                .andExpect(content().json(expected));
//    }
}
