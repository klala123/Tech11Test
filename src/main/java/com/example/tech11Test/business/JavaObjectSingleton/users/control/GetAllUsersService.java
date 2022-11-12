package com.example.tech11Test.business.JavaObjectSingleton.users.control;

import com.example.tech11Test.business.abstractModule.AbstractGetAllState;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;
import com.example.tech11Test.business.abstractModule.AbstractStorage;
import org.apache.commons.lang.StringUtils;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GetAllUsersService extends AbstractGetAllState<UserEntity> {

    @Inject
    AbstractStorage<UserEntity> abstractStorage;

    @Override
    public List<UserEntity> getAllUsers(int limit, int offset) {
      return   abstractStorage.findAll().stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }


    public List<UserEntity> getAllUsers (int limit, int offset, String ... filter ){
        if (filter.length == 0) return  getAllUsers(limit , offset) ;
        return  abstractStorage
                .findByFilters(byFilter(filter))
                .stream()
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private Predicate<UserEntity> byFilter(final String...filter )
    {
        return user -> byFirstName(user , filter[0]) &&
                       byLastName(user , filter[1]) &&
                        byEmail(user , filter[2]);

    }
    private boolean byFirstName(UserEntity user , String firstName){
        return StringUtils.isEmpty(firstName) || user.getFirstName().equalsIgnoreCase(firstName );
    }

    private boolean byLastName(UserEntity user , String lastName){
        return StringUtils.isEmpty(lastName) || user.getLastName().equalsIgnoreCase(lastName );
    }

    private boolean byEmail(UserEntity user , String email){
        return StringUtils.isEmpty(email) || user.getEmail().equalsIgnoreCase(email );
    }



}
