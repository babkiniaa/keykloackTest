package org.babkiniaa.mappers;

import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.entity.CarDealerShip;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface DealerMapper {

    @Mapping(target = "fullAddress", source = "fullAddress")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "isActive", source = "isActive")
    Dealers map(CarDealerShip ship);

}
