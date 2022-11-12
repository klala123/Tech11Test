package com.example.tech11Test.business.JavaObjectSingleton.users.boundary;

import com.example.tech11Test.business.abstractModule.AbstractServiceInjections;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
public class GetUserResource extends AbstractServiceInjections {

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser (@PathParam("id")  final Long userId){
        try {
            return Response.ok(getUserService.getUser(userId)).build();
        }catch (WebApplicationException e ){
            return Response.status(404).build();
        }
    }
}
