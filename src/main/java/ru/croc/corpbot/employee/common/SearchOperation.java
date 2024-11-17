package ru.croc.corpbot.employee.common;

import lombok.Getter;

/**
  \brief Поисковая операция.

 */
public enum SearchOperation {

    /**
     * Равенство.
     */
    EQUALS("="),

    /**
     * Вхождение в (для строковых значений).
     */
    CONTAINS("LIKE");

    @Getter
    private String operation;

    SearchOperation(String operation) {
        this.operation = operation;
    }
}