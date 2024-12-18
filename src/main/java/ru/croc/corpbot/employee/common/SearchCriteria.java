package ru.croc.corpbot.employee.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Класс для выполнения математических операций.
 *
 * @author matvey
 * @version 0.45
 */
@RequiredArgsConstructor
@Getter
public class SearchCriteria {

    /**
     * @param
     * search atribute
     */
    private final String key;

    /**
     * @param
     * comparation operation
     */
    private final String operation;

    /**
     * @param
     * key of search
     */
    private final Object value;
}