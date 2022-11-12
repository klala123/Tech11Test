package com.example.tech11Test.business.abstractModule;

import com.example.tech11Test.business.JavaObjectSingleton.users.control.*;
import com.example.tech11Test.business.JavaObjectSingleton.users.control.requiredServices.PostUserService;
import com.example.tech11Test.business.JavaObjectSingleton.users.control.requiredServices.PutUserService;

import javax.inject.Inject;

public abstract class AbstractServiceInjections {
    @Inject
    protected
    GetAllUsersService getAllUsersService;
    @Inject
    protected
    GetUserService getUserService;

    @Inject
    protected
    PostUserService postUserService;
    @Inject
    protected
    PutUserService putUserService;
    @Inject
    protected
    DeleteUserService deleteUserService;

}
