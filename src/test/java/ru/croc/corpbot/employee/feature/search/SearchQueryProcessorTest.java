package ru.croc.corpbot.employee.feature.search;

import io.qameta.allure.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchQueryProcessorTest {

    @Test
    @Description("Check processQueryTest")
    void processQueryTest() {
        SearchQueryProcessor searchQueryProcessor = new SearchQueryProcessor();

        String query1 = "example@gmail.com";
        var res1 = searchQueryProcessor.identifySearchAttribute(query1);
        System.out.println(res1);

        String query2 = "89991112233";
        var res2 = searchQueryProcessor.identifySearchAttribute(query2);
        System.out.println(res2);

        String query3 = "+79991112233";
        var res3 = searchQueryProcessor.identifySearchAttribute(query3);
        System.out.println(res3);

        String query4 = "7-(999)-111-22-33";
        var res4 = searchQueryProcessor.identifySearchAttribute(query4);
        System.out.println(res4);

        String query5 = "Иванов Иван Иванович";
        var res5 = searchQueryProcessor.identifySearchAttribute(query5);
        System.out.println(res5);

        String query6 = "Иванов";
        var res6 = searchQueryProcessor.identifySearchAttribute(query6);
        System.out.println(res6);

        assertAll(
                () -> assertEquals("email", res1, "Ошибка распознования " + query1),
                () -> assertEquals("phone", res2, "Ошибка распознования " + query2),
                () -> assertEquals("phone", res4, "Ошибка распознования " + query3),
                () -> assertEquals("phone", res4, "Ошибка распознования " + query4)
        );

    }

    @Test
    @Description()
    void identifySearchAttributeTest() {
        SearchQueryProcessor searchQueryProcessor = new SearchQueryProcessor();

        var predicate = searchQueryProcessor.processQuery("Иванов Иван Иваныч");
        System.out.println(predicate);
        Assertions.assertEquals("false = true || containsIc(employee.firstName,иванов) || containsIc(employee.lastName,иванов) || containsIc(employee.patronymic,иванов) || containsIc(employee.firstName,иван) || containsIc(employee.lastName,иван) || containsIc(employee.patronymic,иван) || containsIc(employee.firstName,иваныч) || containsIc(employee.lastName,иваныч) || containsIc(employee.patronymic,иваныч)",
                predicate.toString());

    }
}