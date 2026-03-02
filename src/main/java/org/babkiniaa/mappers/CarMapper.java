package org.babkiniaa.mappers;

import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.entity.CarForSale;
import org.babkiniaa.entity.SoldCars;
import org.babkiniaa.entity.TaskForSale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface CarMapper {

    @Mapping(target = "description", source = "description")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "yearsBorn", source = "yearsBorn")
    @Mapping(target = "urlPhoto", source = "urlPhoto")
    @Mapping(target = "mileage", source = "mileage")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "comment", source = "comment")
    TaskForSale mapCarSaleToTaskForSale(CarSale car);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "yearsBorn", source = "yearsBorn")
    @Mapping(target = "urlPhoto", source = "urlPhoto")
    @Mapping(target = "mileage", source = "mileage")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "idDealerShip", source = "idDealerShip")
    @Mapping(target = "sellerIdOld", source = "sellerId")
    CarForSale mapTaskForSaleToCarForSale(TaskForSale car);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "yearsBorn", source = "yearsBorn")
    @Mapping(target = "urlPhoto", source = "urlPhoto")
    @Mapping(target = "mileage", source = "mileage")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "comment", source = "comment")
    @Mapping(target = "idDealerShip", source = "idDealerShip")
    @Mapping(target = "sellerIdOld", source = "sellerIdOld")
    SoldCars mapCarForSaleToSoldCars(CarForSale car);

    @Mapping(target = "description", source = "description")
    @Mapping(target = "model", source = "model")
    @Mapping(target = "yearsBorn", source = "yearsBorn")
    @Mapping(target = "urlPhoto", source = "urlPhoto")
    @Mapping(target = "mileage", source = "mileage")
    @Mapping(target = "amount", source = "amount")
    @Mapping(target = "comment", source = "comment")
    Cars mapCarForSaleToCars(CarForSale car);

}
