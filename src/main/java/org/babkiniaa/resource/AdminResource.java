package org.babkiniaa.resource;

import io.quarkus.security.Authenticated;
import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.babkiniaa.dto.admin.request.DealerSaleCreate;

@Resource
@Path("/admin")
@Authenticated
public class AdminResource {

    @POST
    @Path("/create/dealer")
    @RolesAllowed("admin")
    public Response openNewDealerShip(DealerSaleCreate dealerSaleCreate) {
        return Response.status(200).build();
    }

    @POST
    @Path("/drop/dealer/{id}")
    @RolesAllowed("admin")
    public Response dropDealerShip(@QueryParam("id") Long id) {
        return Response.status(200).build();
    }

    @POST
    @Path("/drop/user/{id}")
    @RolesAllowed("admin")
    public Response dropUser(@QueryParam("id") Long id) {
        return Response.status(200).build();
    }
}
