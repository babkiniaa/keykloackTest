package org.babkiniaa.resource;

import org.babkiniaa.dto.admin.request.DealerSaleCreate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class AdminResourceTest {

    AdminResource adminResource = new AdminResource();

    @Test
    void openNewDealerShip() {
        Assertions.assertEquals(200, adminResource.openNewDealerShip(new DealerSaleCreate()).getStatus());
    }

    @Test
    void dropDealerShip() {
        Assertions.assertEquals(200, adminResource.dropDealerShip(1L).getStatus());
    }

    @Test
    void dropUser() {
        Assertions.assertEquals(200, adminResource.dropUser(1L).getStatus());
    }
}