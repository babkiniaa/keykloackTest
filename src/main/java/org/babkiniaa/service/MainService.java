package org.babkiniaa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.dto.resources.user.response.UserInfo;

import java.util.List;


@ApplicationScoped
public class MainService {

    private final DealerSaleService dealerSaleService;

    private final UserService userService;

    @Inject
    public MainService(DealerSaleService dealerSaleService, UserService userService) {
        this.dealerSaleService = dealerSaleService;
        this.userService = userService;
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
        dealerSaleService.removeCar(id);
    }

    public List<Dealers> getDealersInCity(String city) {
        return dealerSaleService.getDealersSaleInCity(city);
    }

    public List<Cars> getCarsInCity(String city) {
        return dealerSaleService.getCarInCity(city);
    }

    public void removeCustomer(Long id) {
        userService.removeUser(id);
    }

    public UserInfo getUserInfo(String email) {
        return userService.getUserInfo(email);
    }
}
