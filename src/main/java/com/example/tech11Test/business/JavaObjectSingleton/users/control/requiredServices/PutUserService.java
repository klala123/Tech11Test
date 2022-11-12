package com.example.tech11Test.business.JavaObjectSingleton.users.control.requiredServices;

import com.example.tech11Test.business.abstractModule.AbstractPutState;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;
import com.example.tech11Test.business.abstractModule.AbstractStorage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

public class PutUserService extends AbstractPutState<UserEntity> {
    @Inject
    AbstractStorage<UserEntity> abstractStorage;
    @Override
    public void updateUser(UserEntity module, long moduleId) {
        if(module.getId() == moduleId && abstractStorage.containsId(moduleId)) abstractStorage.update(module);
        else throw new WebApplicationException(400);
    }
}
