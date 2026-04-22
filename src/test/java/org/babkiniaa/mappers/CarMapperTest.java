package org.babkiniaa.mappers;

import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.entity.Car;
import org.babkiniaa.entity.CarForSale;
import org.babkiniaa.entity.SoldCars;
import org.babkiniaa.entity.TaskForSale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class CarMapperTest {

    CarMapper carMapper = new CarMapperImpl();

    @Test
    void mapCarSaleToTaskForSale() {
        CarSale carSale = new CarSale();
        carSale.setDescription("Test Description");
        carSale.setModel("Camry");
        carSale.setYearsBorn("2020");
        carSale.setUrlPhoto("http://photo.com");
        carSale.setMileage(10000L);
        carSale.setAmount(25000L);
        carSale.setComment("Test comment");

        TaskForSale expected = new TaskForSale();
        expected.description = "Test Description";
        expected.model = "Camry";
        expected.yearsBorn = "2020";
        expected.urlPhoto = "http://photo.com";
        expected.mileage = 10000L;
        expected.amount = 25000L;
        expected.comment = "Test comment";

        TaskForSale result = carMapper.mapCarSaleToTaskForSale(carSale);

        assertNotNull(result);
        assertEquals(expected.description, result.description);
        assertEquals(expected.model, result.model);
        assertEquals(expected.yearsBorn, result.yearsBorn);
        assertEquals(expected.urlPhoto, result.urlPhoto);
        assertEquals(expected.mileage, result.mileage);
        assertEquals(expected.amount, result.amount);
        assertEquals(expected.comment, result.comment);
    }

    @Test
    void mapCarSaleToTaskForSaleNull() {
        Assertions.assertNull(carMapper.mapCarSaleToTaskForSale(null));
    }

    @Test
    void mapTaskForSaleToCarForSale() {
        TaskForSale taskForSale = new TaskForSale();
        taskForSale.description = "Description";
        taskForSale.model = "Accord";
        taskForSale.yearsBorn = "2021";
        taskForSale.urlPhoto = "http://photo.com";
        taskForSale.mileage = 15000L;
        taskForSale.amount = 30000L;

        CarForSale expected = new CarForSale();
        expected.description = "Description";
        expected.model = "Accord";
        expected.yearsBorn = "2021";
        expected.urlPhoto = "http://photo.com";
        expected.mileage = 15000L;
        expected.amount = 30000L;

        CarForSale result = carMapper.mapTaskForSaleToCarForSale(taskForSale);

        assertNotNull(result);
        assertEquals(expected.description, result.description);
        assertEquals(expected.model, result.model);
        assertEquals(expected.yearsBorn, result.yearsBorn);
        assertEquals(expected.urlPhoto, result.urlPhoto);
        assertEquals(expected.mileage, result.mileage);
        assertEquals(expected.amount, result.amount);
    }

    @Test
    void mapTaskForSaleToCarForSaleNull() {
        Assertions.assertNull(carMapper.mapTaskForSaleToCarForSale(null));
    }

    @Test
    void mapCarForSaleToSoldCars() {
        CarForSale carForSale = new CarForSale();
        carForSale.description = "Sold Description";
        carForSale.model = "Civic";
        carForSale.yearsBorn = "2019";
        carForSale.urlPhoto = "http://photo.com";
        carForSale.mileage = 20000L;
        carForSale.amount = 18000L;

        SoldCars expected = new SoldCars();
        expected.description = "Sold Description";
        expected.model = "Civic";
        expected.yearsBorn = "2019";
        expected.urlPhoto = "http://photo.com";
        expected.mileage = 20000L;
        expected.amount = 18000L;

        SoldCars result = carMapper.mapCarForSaleToSoldCars(carForSale);

        assertNotNull(result);
        assertEquals(expected.description, result.description);
        assertEquals(expected.model, result.model);
        assertEquals(expected.yearsBorn, result.yearsBorn);
        assertEquals(expected.urlPhoto, result.urlPhoto);
        assertEquals(expected.mileage, result.mileage);
        assertEquals(expected.amount, result.amount);
    }

    @Test
    void mapCarForSaleToSoldCarsNull() {
        Assertions.assertNull(carMapper.mapCarForSaleToSoldCars(null));
    }

    @Test
    void mapCarForSaleToCars() {
        CarForSale carForSale = new CarForSale();
        carForSale.description = "Car Description";
        carForSale.model = "CR-V";
        carForSale.yearsBorn = "2022";
        carForSale.urlPhoto = "http://photo.com";
        carForSale.mileage = 5000L;
        carForSale.amount = 35000L;

        Cars expected = new Cars();
        expected.setDescription("Car Description");
        expected.setModel("CR-V");
        expected.setYearsBorn("2022");
        expected.setUrlPhoto("http://photo.com");
        expected.setMileage(5000L);
        expected.setAmount(35000L);

        Cars result = carMapper.mapCarForSaleToCars(carForSale);

        assertNotNull(result);
        assertEquals(expected.getDescription(), result.getDescription());
        assertEquals(expected.getModel(), result.getModel());
        assertEquals(expected.getYearsBorn(), result.getYearsBorn());
        assertEquals(expected.getUrlPhoto(), result.getUrlPhoto());
        assertEquals(expected.getMileage(), result.getMileage());
        assertEquals(expected.getAmount(), result.getAmount());
    }

    @Test
    void mapCarToCarsForSale() {
        Car car = new Car();
        car.description = "Original Car";
        car.model = "Pilot";
        car.yearsBorn = "2023";
        car.urlPhoto = "http://photo.com";
        car.mileage = 1000L;
        car.amount = 45000L;

        CarForSale expected = new CarForSale();
        expected.description = "Original Car";
        expected.model = "Pilot";
        expected.yearsBorn = "2023";
        expected.urlPhoto = "http://photo.com";
        expected.mileage = 1000L;
        expected.amount = 45000L;

        CarForSale result = carMapper.mapCarToCarsForSale(car);

        assertNotNull(result);
        assertEquals(expected.description, result.description);
        assertEquals(expected.model, result.model);
        assertEquals(expected.yearsBorn, result.yearsBorn);
        assertEquals(expected.urlPhoto, result.urlPhoto);
        assertEquals(expected.mileage, result.mileage);
        assertEquals(expected.amount, result.amount);
    }

    @Test
    void mapCarToCarsForSaleNull() {
        Assertions.assertNull(carMapper.mapCarToCarsForSale(null));
    }
}