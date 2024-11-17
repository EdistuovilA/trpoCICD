package ru.croc.corpbot.employee.common;

import lombok.Getter;

/**
 * Поисковая операция.
 *
 * @author vkhlybov
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