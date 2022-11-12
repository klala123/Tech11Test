package com.example.tech11Test.business.JavaObjectSingleton.users.control;

import com.example.tech11Test.business.abstractModule.AbstractDeleteState;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;
import com.example.tech11Test.business.abstractModule.AbstractStorage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;

public class DeleteUserService extends AbstractDeleteState<UserEntity> {
    @Inject
    AbstractStorage<UserEntity> abstractStorage;
    @Override
    public void deleteModule(long moduleId) {
        if (abstractStorage.containsId(moduleId)) abstractStorage.delete(moduleId);
        else throw new WebApplicationException(404);
    }
}
