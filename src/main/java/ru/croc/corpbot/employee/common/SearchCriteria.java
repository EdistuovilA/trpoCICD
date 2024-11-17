package ru.croc.corpbot.employee.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
    \brief Класс для критериев поиска.

    .
 */
@RequiredArgsConstructor
@Getter
public class SearchCriteria {

    /**
     * Поисковый атрибут.
     */
    private final String key;

    /**
     * Операция сравнения.
     */
    private final String operation;

    /**
     * Значение поиска.
     */
    private final Object value;
}