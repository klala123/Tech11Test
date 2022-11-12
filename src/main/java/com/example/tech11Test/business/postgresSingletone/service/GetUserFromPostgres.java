package com.example.tech11Test.business.postgresSingletone.service;

import com.example.tech11Test.business.abstractModule.AbstractGetState;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityDTO;
import com.example.tech11Test.business.postgresSingletone.storage.UserStorageDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("usersdao")
public class GetUserFromPostgres extends AbstractGetState<UserEntityDTO> {
    @Inject
    UserStorageDao storageDao;
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public UserEntityDTO getUser (@PathParam("id")  final Long userId){

        try {
            return storageDao.getUser(userId);
        }catch (Exception e ){
            throw new WebApplicationException(404);
        }
    }




}
