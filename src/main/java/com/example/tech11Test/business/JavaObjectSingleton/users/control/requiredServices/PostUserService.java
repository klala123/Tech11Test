package com.example.tech11Test.business.JavaObjectSingleton.users.control.requiredServices;

import com.example.tech11Test.business.abstractModule.AbstractPostState;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;
import com.example.tech11Test.business.abstractModule.AbstractStorage;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;


public class PostUserService extends AbstractPostState<UserEntity> {
    @Inject
    AbstractStorage<UserEntity> abstractStorage;
    @Override
    public void postUser(UserEntity user) {
        abstractStorage.create(user);
    }
}
