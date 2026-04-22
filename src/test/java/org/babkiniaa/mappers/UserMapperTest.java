package org.babkiniaa.mappers;

import org.babkiniaa.dto.resources.user.response.UserInfo;
import org.babkiniaa.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserMapperTest {

    UserMapper userMapper = new UserMapperImpl();

    @Test
    void mapCustomerToUserInfo() {
        Date birthDate = new Date();
        Date createdAt = new Date();

        Customer customer = new Customer();
        customer.id = 1L;
        customer.firstName = "John";
        customer.lastName = "Doe";
        customer.middleName = "Michael";
        customer.phone = "+1234567890";
        customer.email = "john.doe@example.com";
        customer.passportSeries = "1234";
        customer.passportNumber = "567890";
        customer.registrationAddress = "123 Main St";
        customer.actualAddress = "456 Oak Ave";
        customer.birthDate = birthDate;
        customer.createdAt = createdAt;

        UserInfo expected = new UserInfo();
        expected.setId(1L);
        expected.setFirstName("John");
        expected.setLastName("Doe");
        expected.setMiddleName("Michael");
        expected.setPhone("+1234567890");
        expected.setEmail("john.doe@example.com");
        expected.setPassportSeries("1234");
        expected.setPassportNumber("567890");
        expected.setRegistrationAddress("123 Main St");
        expected.setActualAddress("456 Oak Ave");
        expected.setBirthDate(birthDate);
        expected.setCreatedAt(createdAt);

        UserInfo result = userMapper.mapCustomerToUserInfo(customer);

        assertNotNull(result);
        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getMiddleName(), result.getMiddleName());
        assertEquals(expected.getPhone(), result.getPhone());
        assertEquals(expected.getEmail(), result.getEmail());
        assertEquals(expected.getPassportSeries(), result.getPassportSeries());
        assertEquals(expected.getPassportNumber(), result.getPassportNumber());
        assertEquals(expected.getRegistrationAddress(), result.getRegistrationAddress());
        assertEquals(expected.getActualAddress(), result.getActualAddress());
        assertEquals(expected.getBirthDate(), result.getBirthDate());
        assertEquals(expected.getCreatedAt(), result.getCreatedAt());
    }

    @Test
    void mapCustomerToUserInfoNull() {
        Assertions.assertNull(userMapper.mapCustomerToUserInfo(null));
    }
}