package com.example.tech11Test.business.postgresSingletone.service;

import com.example.tech11Test.business.abstractModule.AbstractDeleteState;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityDao;
import com.example.tech11Test.business.postgresSingletone.storage.UserStorageDao;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

@Path("usersdao")
public class DeleteUserFromPostgres extends AbstractDeleteState<UserEntityDao> {
    @Inject
    UserStorageDao storageDao;
    @DELETE
    @Path("{id}")
    public void deleteModule(@PathParam("id") long userId){
        try{
            storageDao.deleteUser(userId);
        }catch (Exception e ){
            throw new WebApplicationException(404);
        }
    }



}
