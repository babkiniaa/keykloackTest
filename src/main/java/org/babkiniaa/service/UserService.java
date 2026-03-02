package org.babkiniaa.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.babkiniaa.dto.resources.user.response.UserInfo;
import org.babkiniaa.entity.Customer;
import org.babkiniaa.mappers.UserMapper;

@ApplicationScoped
public class UserService {

    private final EntityManager entityManager;

    private final UserMapper userMapper;

    @Inject
    public UserService(EntityManager entityManager, UserMapper userMapper) {
        this.entityManager = entityManager;
        this.userMapper = userMapper;
    }

    @Transactional
    public void removeUser(Long id) {
        Customer customer = Customer.findById(id);

        if (customer == null) {
            throw new RuntimeException("Пользователь с id не найден " + id);
        }

        entityManager.remove(customer);
    }

    public UserInfo getUserInfo(String email) {
        Customer customer = Customer.findCustomerByEmail(email);

        return userMapper.mapCustomerToUserInfo(customer);
    }
}
