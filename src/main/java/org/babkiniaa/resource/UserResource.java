package org.babkiniaa.resource;

import jakarta.annotation.Resource;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.babkiniaa.dto.user.response.UserInfo;

@Resource
@Path("/user")
public class UserResource {

    @POST
    @Path("/remove/{id}")
    @RolesAllowed("admin")
    public Response removeUser(@QueryParam("id") Long userId) {
        return Response.accepted().build();
    }

    @GET
    @Path("/get/{id}")
    @RolesAllowed("admin")
    public UserInfo getUser(@QueryParam("id") Long userId) {
        return new UserInfo();
    }
}
