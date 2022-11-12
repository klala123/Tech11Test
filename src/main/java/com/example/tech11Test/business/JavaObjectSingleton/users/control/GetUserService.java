package com.example.tech11Test.business.JavaObjectSingleton.users.control;

import com.example.tech11Test.business.abstractModule.AbstractGetState;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;
import com.example.tech11Test.business.abstractModule.AbstractStorage;


import javax.inject.Inject;
import javax.ws.rs.WebApplicationException;
import java.util.Optional;

public class GetUserService extends AbstractGetState<UserEntity> {

    @Inject
    AbstractStorage<UserEntity> abstractStorage;
    @Override
    public UserEntity getUser(Long id) {
        Optional<UserEntity> user = abstractStorage.readById(id);
        if (user.isPresent()) return user.get();
        throw new WebApplicationException(404);
    }
}
