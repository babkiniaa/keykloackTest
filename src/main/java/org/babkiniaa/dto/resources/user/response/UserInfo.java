package org.babkiniaa.dto.resources.user.response;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.util.Date;

@Getter
@Setter
public class UserInfo {

    @Schema(description = "Уникальный идентификатор пользователя")
    private Long id;

    @Schema(description = "Имя пользователя")
    private String firstName;

    @Schema(description = "Фамилия пользователя")
    private String lastName;

    @Schema(description = "Отчество пользователя")
    private String middleName;

    @Schema(description = "Контактный телефон")
    private String phone;

    @Schema(description = "Email адрес")
    private String email;

    @Schema(description = "Серия паспорта")
    private String passportSeries;

    @Schema(description = "Номер паспорта")
    private String passportNumber;

    @Schema(description = "Адрес регистрации")
    private String registrationAddress;

    @Schema(description = "Фактический адрес проживания")
    private String actualAddress;

    @Schema(description = "Дата рождения")
    private Date birthDate;

    @Schema(description = "Дата регистрации в системе")
    private Date createdAt;
}
