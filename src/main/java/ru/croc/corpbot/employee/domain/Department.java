package ru.croc.corpbot.employee.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Department {

    /**
     * @param
     * id.
     */
    @Id
    @UuidGenerator
    private UUID id;

    /**
     * @param
     * naming
     */
    @Column(nullable = false)
    private String name;

    /**
     * @param
     * higher department
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "higher_department_id")
    private Department higherDepartment;
}
