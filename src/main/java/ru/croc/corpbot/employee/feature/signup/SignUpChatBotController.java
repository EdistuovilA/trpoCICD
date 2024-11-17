package ru.croc.corpbot.employee.feature.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.croc.corpbot.employee.dto.EmployeeDto;
import ru.croc.corpbot.employee.dto.SignUpChatBotDto;
import ru.croc.corpbot.employee.mapper.EmployeeMapper;
import ru.croc.corpbot.employee.mapper.EmployeeMapperImpl;
import ru.croc.corpbot.employee.repository.EmployeeRepository;

@RestController
@RequestMapping("employee")
public class SignUpChatBotController {
    private final EmployeeRepository employeeRepository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public SignUpChatBotController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = new EmployeeMapperImpl();
    }

    @PutMapping
    public ResponseEntity<EmployeeDto> signUp(@RequestBody SignUpChatBotDto signUpData) {
        var employeeExistence = employeeRepository
                .findByPhone(signUpData.getPhone());
        if (employeeExistence.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var employee = employeeExistence.get();
        employee.setTgId(signUpData.getChatId().toString());
        employee = employeeRepository.save(employee);

        return ResponseEntity.ok(employeeMapper.employeeToEmployeeDto(employee));
    }



}
