package org.babkiniaa.service;

import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class MainServiceTest {
    @Mock
    DealerSaleService dealerSaleService;

    @Mock
    UserService userService;

    @InjectMocks
    MainService mainService;

    @Test
    void createTaskForSaleCar() {
        mainService.createTaskForSaleCar(new CarSale());
    }

    @Test
    void approveTaskForCarSale() {
        mainService.approveTaskForCarSale(1L);
    }

    @Test
    void boughtCar() {
        mainService.boughtCar(new BoughtCar());
    }

    @Test
    void removeCar() {
        mainService.removeCar(1L);
    }

    @Test
    void getDealersInCity() {
        mainService.getDealersInCity("Vologda");
    }

    @Test
    void getCarsInCity() {
        mainService.getCarsInCity("Vologda");
    }

    @Test
    void removeCustomer() {
        mainService.removeCustomer(1L);
    }

    @Test
    void getUserInfo() {
        mainService.getUserInfo("email@rambler.ru");
    }
}