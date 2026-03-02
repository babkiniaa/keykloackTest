package org.babkiniaa.mappers;

import org.babkiniaa.dto.resources.user.response.UserInfo;
import org.babkiniaa.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "middleName", source = "middleName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "passportSeries", source = "passportSeries")
    @Mapping(target = "passportNumber", source = "passportNumber")
    @Mapping(target = "registrationAddress", source = "registrationAddress")
    @Mapping(target = "actualAddress", source = "actualAddress")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "createdAt", source = "createdAt")
    UserInfo mapCustomerToUserInfo(Customer customer);
}
