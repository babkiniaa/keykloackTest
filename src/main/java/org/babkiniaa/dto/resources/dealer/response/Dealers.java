package org.babkiniaa.dto.resources.dealer.response;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
public class Dealers {

    @Schema(description = "Полный адресс")
    private String fullAddress;

    @Schema(description = "Номер телефона")
    private String phone;

    @Schema(description = "Электронная почта")
    private String email;

    @Schema(description = "Имя")
    private String name;

    @Schema(description = "Работает ли автосалон")
    private Boolean isActive;

}
