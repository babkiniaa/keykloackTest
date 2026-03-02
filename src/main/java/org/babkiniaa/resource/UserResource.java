package org.babkiniaa.resource;

import io.quarkus.security.Authenticated;
import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.babkiniaa.dto.resources.user.response.UserInfo;
import org.babkiniaa.service.MainService;

@Resource
@Path("/user")
@Authenticated
public class UserResource {

    @Inject
    MainService mainService;

    @POST
    @Path("/remove/{id}")
    @RolesAllowed("admin")
    public Response removeUser(@QueryParam("id") Long userId) {
        mainService.removeCustomer(userId);
        return Response.accepted().build();
    }

    @GET
    @Path("/get/{email}")
    @RolesAllowed({"admin", "dealer"})
    public UserInfo getUser(@QueryParam("email") String email) {
        return mainService.getUserInfo(email);
    }
}
