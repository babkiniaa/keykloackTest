package org.babkiniaa.resource;


import io.quarkus.security.Authenticated;
import jakarta.annotation.Resource;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.babkiniaa.dto.dealer.request.CarSale;
import org.babkiniaa.dto.dealer.response.Cars;
import org.babkiniaa.dto.dealer.response.Dealers;

import java.util.Arrays;
import java.util.List;

@Path("/dealer")
@Resource
@Authenticated
public class DealerResource {

    @POST
    @Path("/sale/car")
    @RolesAllowed({"saler", "admin", "dealer"})
    public Response saleMyCar(CarSale carForSale) {
        return Response.status(200).build();
    }

    @POST
    @Path("/car/bought/{id}")
    @RolesAllowed({"admin", "dealer"})
    public Response boughtCar(@QueryParam("id") Long id) {
        return Response.status(200).build();
    }

    @POST
    @Path("/car/remove/{id}")
    @RolesAllowed({"admin", "dealer"})
    public Response removeCarFromSale(@QueryParam("id") Long id) {
        return Response.status(200).build();
    }

    @GET
    @Path("/get/{city}")
    @PermitAll
    public List<Dealers> getDealerByCity(@QueryParam("city") String city) {
        return Arrays.asList(new Dealers());
    }

    @GET
    @Path("/get/cars/{city}")
    @PermitAll
    public List<Cars> getCarsByCity(@QueryParam("city") String city) {
        return Arrays.asList(new Cars());
    }

}
