package org.babkiniaa.resource;

import org.babkiniaa.dto.resources.user.response.UserInfo;
import org.babkiniaa.service.MainService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserResourceTest {

    @Mock
    MainService mainService;

    @InjectMocks
    UserResource userResource;

    @Test
    void removeUser() {
        Assertions.assertNotNull(userResource.removeUser(1L));
    }

    @Test
    void getUser() {
        Mockito.when(mainService.getUserInfo(Mockito.anyString())).thenReturn(new UserInfo());
        Assertions.assertNotNull(userResource.getUser("Test@grge.ru"));
    }
}