package org.babkiniaa.dto.resources.dealer.request;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Setter
@Getter
public class CarSale {

    @Schema(description = "Описание")
    private String description;

    @Schema(description = "Марка")
    private String mark;

    @Schema(description = "Модель")
    private String model;

    @Schema(description = "Дата выпуска")
    private String yearsBorn;

    @Schema(description = "Некие фоточки")
    private String urlPhoto;

    @Schema(description = "Название салона для продажи")
    private String dealerSaleName;

    @Schema(description = "Город нахождения салона")
    private String dealerSaleCity;

    @Schema(description = "email продавца")
    private String emailCustomer;

    @Schema(description = "Комментарий к продаже")
    private String comment;

    @Schema(description = "Пробег")
    private Long mileage;

    @Schema(description = "Стоимость продажи")
    private Long amount;


}
