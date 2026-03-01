package org.babkiniaa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.babkiniaa.dto.resources.dealer.request.CarSale;


@ApplicationScoped
public class MainService {

    DealerSaleService dealerSaleService;

    @Inject
    public MainService(DealerSaleService dealerSaleService) {
        this.dealerSaleService = dealerSaleService;
    }

    public void createTaskForSaleCar(CarSale car) {
        dealerSaleService.createTaskCar(car);
    }

}
