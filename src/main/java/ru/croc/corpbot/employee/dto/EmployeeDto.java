package ru.croc.corpbot.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * DTO-модель сотрудника.
 *
 * @author vkhlybov
 */
@Getter
@Setter
public class EmployeeDto {

    private UUID id;

    private String lastName;

    private String firstName;

    private String patronymic;

    private String position;

    private String department;

    private String phone;

    private String email;
}