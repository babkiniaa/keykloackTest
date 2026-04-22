package org.babkiniaa.resource;

import jakarta.ws.rs.core.Response;
import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.service.MainService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DealerResourceTest {

    @Mock
    MainService mainService;

    @InjectMocks
    DealerResource dealerResource;

    @Test
    void saleMyCar() {
        CarSale carSale = new CarSale();

        Response response = dealerResource.saleMyCar(carSale);

        assertEquals(200, response.getStatus());
    }

    @Test
    void approveCar() {
        Long carId = 1L;
        doNothing().when(mainService).approveTaskForCarSale(carId);

        Response response = dealerResource.approveCar(carId);

        assertEquals(200, response.getStatus());
    }

    @Test
    void boughtCar() {
        BoughtCar boughtCar = new BoughtCar();

        doNothing().when(mainService).boughtCar(any(BoughtCar.class));

        Response response = dealerResource.boughtCar(boughtCar);

        assertEquals(200, response.getStatus());
    }

    @Test
    void removeCarFromSale() {
        Long carId = 5L;
        doNothing().when(mainService).removeCar(carId);

        Response response = dealerResource.removeCarFromSale(carId);

        assertEquals(200, response.getStatus());
    }

    @Test
    void getDealerByCity() {
        String city = "Moscow";
        List<Dealers> expectedDealers = Arrays.asList();

        when(mainService.getDealersInCity(city)).thenReturn(expectedDealers);
        List<Dealers> result = dealerResource.getDealerByCity(city);

        assertNotNull(result);
    }

    @Test
    void getCarsByCity() {
        String city = "Moscow";
        List<Cars> expectedCars = Arrays.asList();

        when(mainService.getCarsInCity(city)).thenReturn(expectedCars);

        List<Cars> result = dealerResource.getCarsByCity(city);

        assertNotNull(result);
    }
}