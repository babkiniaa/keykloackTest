package org.babkiniaa.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.EntityManager;
import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.entity.*;
import org.babkiniaa.mappers.CarMapper;
import org.babkiniaa.mappers.DealerMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class DealerSaleServiceTest {

    @Mock
    CarMapper carMapper;
    @Mock
    DealerMapper dealerMapper;
    @Mock
    EntityManager entityManager;
    @Spy
    @InjectMocks
    DealerSaleService dealerSaleService;

    @Test
    void createTaskCar() {
        CarSale car = new CarSale();
        TaskForSale task = new TaskForSale();
        CarDealerShip carDealerShip = new CarDealerShip();
        Customer customer = new Customer();
        car.setMark("Toyota");
        car.setModel("RAV4");
        car.setDealerSaleCity("Vologda");
        car.setDealerSaleName("To4ka");
        car.setEmailCustomer("tst@email.ru");

        Mockito.when(carMapper.mapCarSaleToTaskForSale(Mockito.any())).thenReturn(task);
        Mockito.doReturn(carDealerShip).when(dealerSaleService).getDealerShipByNameAndCity(Mockito.anyString(), Mockito.anyString());
        Mockito.doReturn(customer).when(dealerSaleService).getCustomerByEmail(Mockito.anyString());

        Assertions.assertDoesNotThrow(() -> dealerSaleService.createTaskCar(car));
    }


    @ParameterizedTest
    @MethodSource("approveTaskSource")
    void approveTaskCarSale(Class<Exception> clazz, Long id) {
        TaskForSale task = new TaskForSale();
        try (MockedStatic<PanacheEntityBase> panacheMock = Mockito.mockStatic(PanacheEntityBase.class)) {
            panacheMock.when(() -> TaskForSale.findById(Mockito.anyLong())).thenReturn(task);
            if (clazz == null) {
                Mockito.when(carMapper.mapTaskForSaleToCarForSale(Mockito.any())).thenReturn(new CarForSale());
                Assertions.assertDoesNotThrow(() -> dealerSaleService.approveTaskCarSale(id));
            } else {
                Assertions.assertThrows(clazz, () -> dealerSaleService.approveTaskCarSale(id));
            }
        }
    }

    static Stream<Arguments> approveTaskSource() {
        return Stream.of(
                Arguments.of(null, 1L),
                Arguments.of(RuntimeException.class, null)
        );
    }

    @ParameterizedTest
    @MethodSource("boughtCarSource")
    void boughtCar(Class<Exception> clazz, BoughtCar car) {
        CarForSale carForSale = new CarForSale();
        try (MockedStatic<PanacheEntityBase> panacheMock = Mockito.mockStatic(PanacheEntityBase.class)) {
            panacheMock.when(() -> CarForSale.findById(Mockito.anyLong())).thenReturn(carForSale);
            if (clazz == null) {
                SoldCars soldCars = new SoldCars();
                Customer customer = new Customer();
                Mockito.when(carMapper.mapCarForSaleToSoldCars(Mockito.any())).thenReturn(soldCars);
                Mockito.doReturn(customer).when(dealerSaleService).getCustomerByEmail(Mockito.anyString());
                Assertions.assertDoesNotThrow(() -> dealerSaleService.boughtCar(car));
            } else {
                Assertions.assertThrows(clazz, () -> dealerSaleService.boughtCar(car));
            }

        }
    }

    static Stream<Arguments> boughtCarSource() {
        BoughtCar boughtCar = new BoughtCar();
        BoughtCar boughtCar1 = new BoughtCar();
        boughtCar.setIdCar(2L);
        boughtCar.setCustomerEmail("yandex@spam.ru");
        return Stream.of(
                Arguments.of(null, boughtCar),
                Arguments.of(RuntimeException.class, boughtCar1)
        );
    }

    @ParameterizedTest
    @MethodSource("removeCarSource")
    void removeCar(Class<Exception> clazz, Long id) {
        CarForSale carForSale = new CarForSale();
        try (MockedStatic<PanacheEntityBase> panacheMock = Mockito.mockStatic(PanacheEntityBase.class)) {
            panacheMock.when(() -> CarForSale.findById(Mockito.anyLong())).thenReturn(carForSale);
            if (clazz == null) Assertions.assertDoesNotThrow(() -> dealerSaleService.removeCar(id));
            else Assertions.assertThrows(clazz, () -> dealerSaleService.removeCar(id));
        }
    }

    static Stream<Arguments> removeCarSource() {
        return Stream.of(
                Arguments.of(null, 1L),
                Arguments.of(RuntimeException.class, null)
        );
    }

    @Test
    void getDealersSaleInCity() {
        String city = "Viborg";
        try (MockedStatic<CarDealerShip> carDealerMock = Mockito.mockStatic(CarDealerShip.class)) {
            carDealerMock.when(() -> CarDealerShip.findDealerByCity(Mockito.anyString())).thenReturn(List.of(new CarDealerShip()));
            Mockito.when(dealerMapper.map(Mockito.any())).thenReturn(new Dealers());

            Assertions.assertEquals(1, dealerSaleService.getDealersSaleInCity(city).size());
        }
    }

    @Test
    void getCarInCity() {
        String city = "Totma";
        CarDealerShip carDealerShip = new CarDealerShip();
        carDealerShip.carsInDealer = List.of(new Car());
        try (MockedStatic<CarDealerShip> carDealerMock = Mockito.mockStatic(CarDealerShip.class)) {
            carDealerMock.when(() -> CarDealerShip.findDealerByCity(Mockito.anyString())).thenReturn(List.of(carDealerShip));
            Mockito.when(carMapper.mapCarForSaleToCars(Mockito.any())).thenReturn(new Cars());
            Assertions.assertEquals(1, dealerSaleService.getCarInCity(city).size());
        }
    }

    @ParameterizedTest
    @MethodSource("dealerShipSource")
    void getDealerShipByNameAndCity(Class<Exception> clazz, String name, String city) {
        try (MockedStatic<CarDealerShip> carDealerMock = Mockito.mockStatic(CarDealerShip.class)) {
            carDealerMock.when(() -> CarDealerShip.findDealerByNameAndCity(Mockito.anyString(), Mockito.anyString())).thenReturn(new CarDealerShip());

            if (clazz == null) {
                Assertions.assertNotNull(dealerSaleService.getDealerShipByNameAndCity(name, city));
            } else {
                Assertions.assertThrows(clazz, () -> dealerSaleService.getDealerShipByNameAndCity(name, city));
            }
        }
    }

    static Stream<Arguments> dealerShipSource() {
        return Stream.of(
                Arguments.of(RuntimeException.class, "Ty-ty", null),
                Arguments.of(null, "Ty-ty", "Barnayl")
        );
    }


    @ParameterizedTest
    @MethodSource("customerByEmailSource")
    void getCustomerByEmail(Class<Exception> clazz, String email) {
        try (MockedStatic<Customer> customerMock = Mockito.mockStatic(Customer.class)) {
            customerMock.when(() -> Customer.findCustomerByEmail(Mockito.anyString())).thenReturn(new Customer());
            if (clazz == null) {
                Assertions.assertNotNull(dealerSaleService.getCustomerByEmail(email));
            } else {
                Assertions.assertThrows(clazz, () -> dealerSaleService.getDealersSaleInCity(email));
            }
        }
    }

    static Stream<Arguments> customerByEmailSource() {
        return Stream.of(
                Arguments.of(RuntimeException.class, null),
                Arguments.of(null, "email@rambler.ru")
        );
    }
}