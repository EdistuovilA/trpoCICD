package ru.croc.corpbot.employee.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Критерий поиска.
 *
 * @author vkhlybov
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