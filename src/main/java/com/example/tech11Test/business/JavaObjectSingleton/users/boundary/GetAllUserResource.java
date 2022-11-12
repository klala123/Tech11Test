package com.example.tech11Test.business.JavaObjectSingleton.users.boundary;


import com.example.tech11Test.business.abstractModule.AbstractServiceInjections;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collection;

@Path("users")
public class GetAllUserResource extends AbstractServiceInjections {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers(
            @QueryParam("limit") @DefaultValue("10") int limit,
            @QueryParam("offset") @DefaultValue("0") int offset ,
            @QueryParam("firstName") @DefaultValue("") String firstName ,
            @QueryParam("lastName") @DefaultValue("") String lastName ,
            @QueryParam("email") @DefaultValue("") String email
    ){
      return  Response.ok( new GenericEntity<Collection<UserEntity>>
              (getAllUsersService.getAllUsers(limit ,offset, firstName , lastName ,  email ) ) {}).build();
    }




}
