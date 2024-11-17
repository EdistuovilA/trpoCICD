package ru.croc.corpbot.employee.repository;

import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import ru.croc.corpbot.employee.domain.Employee;
import ru.croc.corpbot.employee.domain.QEmployee;

import java.util.Optional;
import java.util.UUID;

public interface EmployeeRepository extends JpaRepository<Employee, UUID>,
        QuerydslPredicateExecutor<Employee>, QuerydslBinderCustomizer<QEmployee> {

    @Override
    default void customize(QuerydslBindings bindings, QEmployee root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

    Optional<Employee> findByPhone(String phone);
}