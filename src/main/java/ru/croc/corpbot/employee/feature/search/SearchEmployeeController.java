package ru.croc.corpbot.employee.feature.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.croc.corpbot.employee.domain.Employee;
import ru.croc.corpbot.employee.dto.EmployeeDto;
import ru.croc.corpbot.employee.mapper.EmployeeMapper;
import ru.croc.corpbot.employee.mapper.EmployeeMapperImpl;
import ru.croc.corpbot.employee.repository.EmployeeRepository;

import java.util.Objects;

@RestController
@RequestMapping("employee")
public class SearchEmployeeController {

    private final SearchQueryProcessor queryProcessor;

    private final EmployeeRepository repository;

    private final EmployeeMapper employeeMapper;

    @Autowired
    public SearchEmployeeController(EmployeeRepository repository) {
        this.repository = repository;
        this.queryProcessor = new SearchQueryProcessor();
        this.employeeMapper = new EmployeeMapperImpl();
    }

    @GetMapping
    public ResponseEntity<EmployeeDto> search(@RequestParam(value = "search", required = false) String search) {
        var employee = (Employee) null;
        if (search != null) {
            var predicate = queryProcessor.processQuery(search);
            employee = repository.findOne(predicate).orElse(null);
        }
        if (Objects.isNull(employee)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(employeeMapper.employeeToEmployeeDto(employee));
        }
    }
}