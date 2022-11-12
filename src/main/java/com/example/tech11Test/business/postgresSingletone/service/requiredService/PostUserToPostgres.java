package com.example.tech11Test.business.postgresSingletone.service.requiredService;

import com.example.tech11Test.business.abstractModule.AbstractPostState;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityCreate;
import com.example.tech11Test.business.postgresSingletone.storage.UserStorageDao;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("usersdao")
public class PostUserToPostgres extends AbstractPostState<UserEntityCreate> {
    @Inject
    UserStorageDao storageDao;
    @POST
    public void postUser(  final UserEntityCreate user ) {
        try {
            storageDao.createUser(user);
        }catch (Exception e ){
            Response.status(400).build();
        }
    }


}
