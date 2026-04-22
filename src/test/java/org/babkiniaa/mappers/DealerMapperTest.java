package org.babkiniaa.mappers;

import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.entity.CarDealerShip;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static io.smallrye.common.constraint.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class DealerMapperTest {

    DealerMapper dealerMapper = new DealerMapperImpl();

    @Test
    void map() {
        CarDealerShip ship = new CarDealerShip();
        ship.fullAddress = "123 Main St, City";
        ship.phone = "+1234567890";
        ship.email = "dealer@example.com";
        ship.name = "Best Cars";
        ship.isActive = true;

        Dealers expected = new Dealers();
        expected.setFullAddress("123 Main St, City");
        expected.setPhone("+1234567890");
        expected.setEmail("dealer@example.com");
        expected.setName("Best Cars");
        expected.setIsActive(true);

        Dealers result = dealerMapper.map(ship);

        assertNotNull(result);
        assertEquals(expected.getFullAddress(), result.getFullAddress());
        assertEquals(expected.getPhone(), result.getPhone());
        assertEquals(expected.getEmail(), result.getEmail());
        assertEquals(expected.getName(), result.getName());
        assertEquals(expected.getIsActive(), result.getIsActive());
    }

    @Test
    void mapNull() {
        Assertions.assertNull(dealerMapper.map(null));
    }
}