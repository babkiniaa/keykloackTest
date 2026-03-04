package org.babkiniaa.dto.resources.dealer.response;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Setter
@Getter
public class Cars {

    @Schema(description = "Описание")
    public String description;

    @Schema(description = "Марка")
    public String mark;

    @Schema(description = "Модель")
    public String model;

    @Schema(description = "Дата выпуска")
    public String yearsBorn;

    @Schema(description = "Некие фоточки")
    public String urlPhoto;

    @Schema(description = "Пробег")
    public Long mileage;

    @Schema(description = "Стоимость")
    public Long amount;
}
