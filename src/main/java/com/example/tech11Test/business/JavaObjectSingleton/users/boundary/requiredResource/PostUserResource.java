package com.example.tech11Test.business.JavaObjectSingleton.users.boundary.requiredResource;

import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;
import com.example.tech11Test.business.abstractModule.AbstractServiceInjections;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("users")
public class PostUserResource extends AbstractServiceInjections {


    @POST
    public Response createUser(UserEntity user){
      postUserService.postUser(user);
        return Response.status(204).build();
    }
}
