package com.example.tech11Test.business.postgresSingletone.service;

import com.example.tech11Test.business.abstractModule.AbstractGetAllState;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityDTO;
import com.example.tech11Test.business.postgresSingletone.storage.UserStorageDao;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("usersdao")
public class GetAllUsersFromPostgres extends AbstractGetAllState<UserEntityDTO> {
    @Inject
    UserStorageDao storageDao;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<UserEntityDTO> getAllUsers( @QueryParam("limit") @DefaultValue("10") int limit,
                                            @QueryParam("offset") @DefaultValue("0") int offset
                                         ){
        return this.storageDao.getAllUsers(limit , offset);
    }


}
