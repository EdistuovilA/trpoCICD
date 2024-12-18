package ru.croc.corpbot.employee.common;

import lombok.Getter;

/**
    search operation
    @author Матвей
 */
public enum SearchOperation {

    /**
     * @param
     * equality.
     */
    EQUALS("="),

    /**
     * @param
     * contains
     */
    CONTAINS("LIKE");

    @Getter
    private String operation;

    SearchOperation(String operation) {
        this.operation = operation;
    }
}