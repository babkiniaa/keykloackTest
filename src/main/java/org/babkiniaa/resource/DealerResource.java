package org.babkiniaa.resource;


import io.quarkus.security.Authenticated;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.babkiniaa.dto.resources.dealer.request.BoughtCar;
import org.babkiniaa.dto.resources.dealer.request.CarSale;
import org.babkiniaa.dto.resources.dealer.response.Cars;
import org.babkiniaa.dto.resources.dealer.response.Dealers;
import org.babkiniaa.service.MainService;

import java.util.List;

@Path("/dealer")
@Resource
@Authenticated
public class DealerResource {

    @Inject
    MainService mainService;

    @POST
    @Path("/sale/car")
    @RolesAllowed({"saler", "admin", "dealer"})
    public Response saleMyCar(CarSale car) {
        mainService.createTaskForSaleCar(car);
        return Response.status(200).build();
    }

    @POST
    @Path("/car/approve/{id}")
    @RolesAllowed({"admin", "dealer"})
    public Response approveCar(@QueryParam("id") Long id) {
        mainService.approveTaskForCarSale(id);
        return Response.status(200).build();
    }

    @POST
    @Path("/car/bought")
    @RolesAllowed({"admin", "dealer"})
    public Response boughtCar(BoughtCar car) {
        mainService.boughtCar(car);
        return Response.status(200).build();
    }

    @POST
    @Path("/car/remove/{id}")
    @RolesAllowed({"admin", "dealer"})
    public Response removeCarFromSale(@QueryParam("id") Long id) {
        mainService.removeCar(id);
        return Response.status(200).build();
    }

    @GET
    @Path("/get/{city}")
    @PermitAll
    public List<Dealers> getDealerByCity(@QueryParam("city") String city) {
        return mainService.getDealersInCity(city);
    }

    @GET
    @Path("/get/cars/{city}")
    @PermitAll
    public List<Cars> getCarsByCity(@QueryParam("city") String city) {
        return mainService.getCarsInCity(city);
    }

}
