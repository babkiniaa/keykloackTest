package org.babkiniaa.dto.resources.dealer.request;

import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

@Getter
@Setter
public class BoughtCar {

    @Schema(description = "email покупателя")
    private String customerEmail;

    @Schema(description = "id машины")
    private Long idCar;
}
