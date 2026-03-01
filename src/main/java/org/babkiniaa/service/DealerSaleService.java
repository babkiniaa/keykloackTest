package org.babkiniaa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.entity.CarDealerShip;
import org.babkiniaa.entity.Customer;
import org.babkiniaa.entity.TaskForSale;
import org.babkiniaa.mappers.CarMapper;

@ApplicationScoped
@Slf4j
public class DealerSaleService {

    CarMapper carMapper;

    EntityManager entityManager;

    @Inject
    public DealerSaleService(CarMapper carMapper, EntityManager entityManager) {
        this.carMapper = carMapper;
        this.entityManager = entityManager;
    }

    @Transactional(rollbackOn = Exception.class)
    public void createTaskCar(CarSale car) {
        log.info("Заявка на выставку машины на продажу: {} {}", car.getMark(), car.getModel());
        TaskForSale task;

        task = carMapper.mapForTaskForSale(car);
        task.idDealerShip = getDealerShipByNameAndCity(car.getDealerSaleName(), car.getDealerSaleCity());
        task.sellerId = getCustomerByEmail(car.getEmailCustomer());

        entityManager.persist(task);
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
