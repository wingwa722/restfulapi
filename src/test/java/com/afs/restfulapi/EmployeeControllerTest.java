package com.afs.restfulapi;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @AfterEach
    void tearDown(){
        this.employeeRepository.deleteAll();
    }

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void should_return_all_employees_when_find_all_given_2_two_employee() throws Exception{
        Employee employee1 = new Employee("Wing", 22, "Female", 101);
        Employee employee2 = new Employee ("Tommy", 18, "Male", 102);

        employeeRepository.createEmployee(employee1);
        employeeRepository.createEmployee(employee2);

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
//
//    @Test
//    void should_return_employee_when_find_one_given_employeeId() throws Exception{
//        Employee employee1 = new Employee("Wing", 22, "Female", 101);
//        Employee employee2 = new Employee ("Tommy", 18, "Male", 102);
//
//        employeeRepository.createEmployee(employee1);
//        employeeRepository.createEmployee(employee2);
//
//        //when
//        ResultActions resultActions = mockMvc.perform(get("/employees/id"));
//
//        //then
//        String expected = "[\n" +
//                "    {\n" +
//                "        \"id\": 1,\n" +
//                "        \"name\": \"Wing\",\n" +
//                "        \"age\": 22,\n" +
//                "        \"gender\": \"Female\",\n" +
//                "        \"salary\": 101\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"id\": 2,\n" +
//                "        \"name\": \"Tommy\",\n" +
//                "        \"age\": 18,\n" +
//                "        \"gender\": \"Male\",\n" +
//                "        \"salary\": 102\n" +
//                "    }\n" +
//                "]";
//        resultActions.andExpect(status().isOk()).andExpect(content().json(expected));
//    }

    @Test
    void should_return_male_employees_when_find_male_employees_given_1_male_employee_and_1_female_employee() throws Exception {
        Employee employee1 = new Employee("Wing", 22, "Female", 101);
        Employee employee2 = new Employee ("Tommy", 18, "Male", 102);

        employeeRepository.createEmployee(employee1);
        employeeRepository.createEmployee(employee2);

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

//    @Test
//    void should_return_created_employee_when_create_employee_given_new_employee_info(){
//        //given
//        String newEmployee = "{\\n\" +\n" +
//                "                \"        \\\"id\\\": 1,\\n\" +\n" +
//                "                \"        \\\"name\\\": \\\"Wing\\\",\\n\" +\n" +
//                "                \"        \\\"age\\\": 22,\\n\" +\n" +
//                "                \"        \\\"gender\\\": \\\"Female\\\",\\n\" +\n" +
//                "                \"        \\\"salary\\\": 101\\n\" +\n" +
//                "                \"    },\\n\" +\n" +
//                "                \"]";
//
//        //when
//        ResultActions resultActions = mockMvc.perform(post("/employees")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(newEmployee));
//
//        //then
//        String expected = "{\\n\" +\n" +
//                "                \"        \\\"id\\\": 1,\\n\" +\n" +
//                "                \"        \\\"name\\\": \\\"Wing\\\",\\n\" +\n" +
//                "                \"        \\\"age\\\": 22,\\n\" +\n" +
//                "                \"        \\\"gender\\\": \\\"Female\\\",\\n\" +\n" +
//                "                \"        \\\"salary\\\": 101\\n\" +\n" +
//                "                \"    },\\n\" +\n" +
//                "                \"]";
//                ResultActions.andExpect(status().isCreated())
//                .andExpect(content().json(expected));
//    }
}
