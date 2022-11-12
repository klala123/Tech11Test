package com.example.tech11Test.business.postgresSingletone.service.requiredService;
import com.example.tech11Test.business.abstractModule.AbstractPutState;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityDao;
import com.example.tech11Test.business.postgresSingletone.storage.UserStorageDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("usersdao")
public class PutUserInPostgres extends AbstractPutState<UserEntityDao> {
    @Inject
    UserStorageDao storageDao;


    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateUser(UserEntityDao user , @PathParam("id") long userId ){
        try{
            storageDao.updateUser(user , userId);

        }catch (Exception e){
             throw new WebApplicationException(400);
        }
    }


    @PUT
    @Path("{id}/{password}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUserPassword(@PathParam("id") long userId , @PathParam("password") String password, UserEntityDao user){
        try{
            storageDao.updateThePassword(password, user , userId);
           return Response.status(204).build();
        }catch (Exception e){
      return Response.status(400).build();   }
    }



}
