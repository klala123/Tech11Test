package com.example.tech11Test.business.JavaObjectSingleton.users.boundary;

import com.example.tech11Test.business.abstractModule.AbstractServiceInjections;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

@Path("users")
public class DeleteUserResource extends AbstractServiceInjections {

    @DELETE
    @Path("{id}")
    public void deleteUser(@PathParam("id") long userId){
        try{
            deleteUserService.deleteModule(userId);
        }catch (WebApplicationException e ){
            throw new WebApplicationException(404);
        }
    }

}
