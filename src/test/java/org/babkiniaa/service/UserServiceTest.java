package org.babkiniaa.service;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.EntityManager;
import org.babkiniaa.dto.resources.user.response.UserInfo;
import org.babkiniaa.entity.Customer;
import org.babkiniaa.mappers.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    EntityManager entityManager;
    @Mock
    UserMapper userMapper;
    @InjectMocks
    UserService userService;

    @ParameterizedTest
    @MethodSource("removeUserSource")
    void removeUser(Class<Exception> clazz, Long id) {
        try (MockedStatic<PanacheEntityBase> mockedStatic = Mockito.mockStatic(PanacheEntityBase.class)) {
            mockedStatic.when(() -> Customer.findById(Mockito.anyLong())).thenReturn(new Customer());
            if (clazz == null) {
                Assertions.assertDoesNotThrow(() -> userService.removeUser(id));
            } else {
                Assertions.assertThrows(clazz, () -> userService.removeUser(id));
            }
        }
    }

    static Stream<Arguments> removeUserSource() {
        return Stream.of(
                Arguments.of(RuntimeException.class, null),
                Arguments.of(null, 1L)
        );
    }

    @Test
    void getUserInfoTest() {
        try (MockedStatic<Customer> mockedStatic = Mockito.mockStatic(Customer.class)) {
            mockedStatic.when(() -> Customer.findCustomerByEmail(Mockito.anyString())).thenReturn(new Customer());
            Mockito.when(userMapper.mapCustomerToUserInfo(Mockito.any())).thenReturn(new UserInfo());

            Assertions.assertNotNull(userService.getUserInfo("yandec@ram.ru"));
        }
    }

}