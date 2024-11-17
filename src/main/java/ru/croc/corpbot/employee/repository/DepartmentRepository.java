package ru.croc.corpbot.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.croc.corpbot.employee.domain.Department;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
}