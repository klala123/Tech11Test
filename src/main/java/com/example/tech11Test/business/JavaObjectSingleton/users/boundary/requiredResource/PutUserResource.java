package com.example.tech11Test.business.JavaObjectSingleton.users.boundary.requiredResource;

import com.example.tech11Test.business.abstractModule.AbstractServiceInjections;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("users")
public class PutUserResource extends AbstractServiceInjections {

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") long userId , UserEntity user){
        try{
            putUserService.updateUser(user , userId);
            return Response.status(204).build();
        }catch (WebApplicationException e){
            return Response.status(400).build();
        }
    }
}
