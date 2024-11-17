package ru.croc.corpbot.employee;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import ru.croc.corpbot.employee.domain.Department;
import ru.croc.corpbot.employee.domain.Employee;
import ru.croc.corpbot.employee.domain.Position;
import ru.croc.corpbot.employee.dto.EmployeeDto;
import ru.croc.corpbot.employee.repository.DepartmentRepository;
import ru.croc.corpbot.employee.repository.EmployeeRepository;
import utils.ReadProperties;


import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
class EmployeeApplicationTests {

    @LocalServerPort
    private Integer port;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    public void setup() {
        var department = new Department();
        department.setName("Основной департамент");
        department = departmentRepository.save(department);

        var employee = new Employee();
        employee.setDepartment(department);
        employee.setFirstName("Иван");
        employee.setLastName("Иванов");
        employee.setPhone("79991234556");
        employee.setPosition(Position.CEO);
        employeeRepository.save(employee);
    }

    @AfterEach
    public void cleanup() {
        employeeRepository.deleteAllInBatch();
        departmentRepository.deleteAllInBatch();
    }

    @Test
    void contextLoads() {

    }

    @Test
    public void employeeTest(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
        RestAssured.useRelaxedHTTPSValidation();

        if(Boolean.valueOf(String.valueOf(ReadProperties.propertiesRead().get("extended.log"))))  RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());

        Response r = given()
                .queryParam("search", "Иванов Иван Иванович")
                .when()
                .get("/employee")
                .then()
                .extract().response();

        Assertions.assertEquals(200, r.getStatusCode(),"Ошибка статус кода r="+r.getBody().asString());


        EmployeeDto resultObject = new Gson().fromJson(r.getBody().asString(), EmployeeDto.class);

        Assertions.assertEquals("Основной департамент",resultObject.getDepartment(),"Ошибка чтения департамента");

    }

}
