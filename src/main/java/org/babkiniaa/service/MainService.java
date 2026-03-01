package org.babkiniaa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;


@ApplicationScoped
public class MainService {

    private final DealerSaleService dealerSaleService;

    @Inject
    public MainService(DealerSaleService dealerSaleService) {
        this.dealerSaleService = dealerSaleService;
    }

    public void createTaskForSaleCar(CarSale car) {
        dealerSaleService.createTaskCar(car);
    }

    public void approveTaskForCarSale(Long id) {
        dealerSaleService.approveTaskCarSale(id);
    }

    public void boughtCar(BoughtCar car) {
        dealerSaleService.boughtCar(car);
    }

    public void removeCar(Long id) {

    }

}
