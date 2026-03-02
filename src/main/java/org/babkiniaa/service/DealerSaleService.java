package org.babkiniaa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.entity.*;
import org.babkiniaa.mappers.CarMapper;
import org.babkiniaa.mappers.DealerMapper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.babkiniaa.constant.Constant.BOUGHT;

@Slf4j
@ApplicationScoped
public class DealerSaleService {

    private final CarMapper carMapper;

    private final DealerMapper dealerMapper;

    private final EntityManager entityManager;

    @Inject
    public DealerSaleService(CarMapper carMapper,
                             DealerMapper dealerMapper,
                             EntityManager entityManager) {
        this.carMapper = carMapper;
        this.dealerMapper = dealerMapper;
        this.entityManager = entityManager;
    }

    @Transactional
    public void createTaskCar(CarSale car) {
        log.info("Заявка на выставку машины на продажу: {} {}", car.getMark(), car.getModel());
        TaskForSale task;

        task = carMapper.mapCarSaleToTaskForSale(car);
        task.idDealerShip = getDealerShipByNameAndCity(car.getDealerSaleName(), car.getDealerSaleCity());
        task.sellerId = getCustomerByEmail(car.getEmailCustomer());

        entityManager.persist(task);
    }

    @Transactional(rollbackOn = Exception.class)
    public void approveTaskCarSale(Long id) {
        log.info("Подтверждение на продажу машины с id {}", id);
        TaskForSale taskCar = TaskForSale.findById(id);
        CarForSale carForSale;

        if (taskCar == null) {
            throw new RuntimeException("Заявка на продажу машины не найдена " + id);
        }
        carForSale = carMapper.mapTaskForSaleToCarForSale(taskCar);

        entityManager.persist(carForSale);
        entityManager.remove(taskCar);
    }

    @Transactional(rollbackOn = Exception.class)
    public void boughtCar(BoughtCar carOrder) {
        log.info("Процесс покупки машины с id {}", carOrder.getIdCar());
        CarForSale car = CarForSale.findById(carOrder.getIdCar());

        if (car == null) {
            throw new RuntimeException("Машина с id не находится в продаже " + carOrder.getIdCar());
        }
        SoldCars soldCar = carMapper.mapCarForSaleToSoldCars(car);
        soldCar.status = BOUGHT;
        soldCar.sellerIdNew = getCustomerByEmail(carOrder.getCustomerEmail());

        entityManager.persist(soldCar);
        entityManager.remove(car);
    }

    @Transactional
    public void removeCar(Long id) {
        CarForSale car = CarForSale.findById(id);

        if (car == null) {
            throw new RuntimeException("Не получилось удалить машину с продажи, мащина с id не найдена " + id);
        }

        entityManager.remove(car);
    }

    public List<Dealers> getDealersSaleInCity(String city) {
        List<CarDealerShip> ships = CarDealerShip.findDealerByCity(city);
        return ships.stream()
                .map(dealerMapper::map)
                .toList();
    }

    public List<Cars> getCarInCity(String city) {
        List<CarDealerShip> carDealerShip = CarDealerShip.findDealerByCity(city);
        List<CarForSale> cars = new ArrayList<>();

        carDealerShip.forEach(car -> {
            cars.addAll((Collection<? extends CarForSale>) car.carsInDealer);
        });

        return cars.stream()
                .map(carMapper::mapCarForSaleToCars)
                .toList();
    }


    public CarDealerShip getDealerShipByNameAndCity(String name, String city) {
        CarDealerShip dealer = CarDealerShip.findDealerByNameAndCity(name, city);

        if (dealer != null) {
            return dealer;
        }

        String msg = String.format("Автосалон не найден при попытке добавить в него автомобиль на продажу " + city + " " + name);
        throw new RuntimeException(msg);
    }

    public Customer getCustomerByEmail(String email) {
        Customer customer = Customer.findCustomerByEmail(email);

        if (customer != null) {
            return customer;
        }

        String msg = String.format("Пользователь не найден для выставки на продажу с email " + email);
        throw new RuntimeException(msg);
    }

}
