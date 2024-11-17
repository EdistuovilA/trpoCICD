package ru.croc.corpbot.employee.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.croc.corpbot.employee.domain.Employee;
import ru.croc.corpbot.employee.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {

    @Mapping(target = "position", expression = "java(employee.getPosition().getRussianName())")
    @Mapping(target = "department", expression = "java(employee.getDepartment().getName())")
    EmployeeDto employeeToEmployeeDto(Employee employee);
}