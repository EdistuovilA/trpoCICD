package ru.croc.corpbot.employee.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder(setterPrefix = "with")
@Getter
@Setter
public class SignUpChatBotDto {

    /**
     * Номер телефона.
     */
    private String phone;

    /**
     * Идентификатор чата сотрудника в боте.
     */
    private Long chatId;
}

