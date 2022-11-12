package com.example.tech11Test.business.JavaObjectSingleton.users.dataBase;

import com.example.tech11Test.business.abstractModule.AbstractStorage;
import com.example.tech11Test.business.JavaObjectSingleton.users.entity.UserEntity;

import javax.annotation.PostConstruct;
import javax.inject.Singleton;
import java.time.LocalDate;
import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Singleton
public class UserStorage extends AbstractStorage<UserEntity> {

    @PostConstruct
    public void init() {
        for (int i = 1; i < 11; i++) {
            create( new UserEntity( "Klala" + i , "Chikhi"+i , "klala.chikhi@studnet.fhws.de"+i ,
                    LocalDate.of( 1997, 6, 16 ) , "password" ) );
        }
    }

    public  Collection<UserEntity> findByFilters( final Predicate<UserEntity> predicate ){
        return this.storage.values( )
                .stream( )
                .filter( predicate )
                .collect( Collectors.toList( ) );
    }



}
