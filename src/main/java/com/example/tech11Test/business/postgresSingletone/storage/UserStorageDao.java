package com.example.tech11Test.business.postgresSingletone.storage;

import com.example.tech11Test.business.postgresSingletone.entity.UserEntityCreate;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityDTO;
import com.example.tech11Test.business.postgresSingletone.entity.UserEntityDao;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.WebApplicationException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Stateless
public class UserStorageDao {
    public UserStorageDao() {
    }

    @PersistenceContext
    EntityManager em;

    @PostConstruct
    public void init(){
        for (int i = 1; i < 11; i++) {
            createUser( new UserEntityCreate( "KlalaDao" + i , "ChikhiDao"+i , "klala.chikhi@studnet.fhws.de"+i ,
                    LocalDate.of( 1997, 6, 16 ) , "password" ) );
        }
    }

    public List<UserEntityDTO> getAllUsers(final int limit , final int offset ){
       List<UserEntityDao> users =  em.createQuery("SELECT users FROM UserEntityDao users").getResultList();
       return users.stream().map(user -> user.toDTOEntity()).skip(offset).limit(limit).collect(Collectors.toList());
    }


    public UserEntityDTO getUser(final long id ) {
        Optional<UserEntityDao> user =  Optional.of(em.find(UserEntityDao.class , id ));
        if (user.isPresent()) return user.get().toDTOEntity();
        else throw new WebApplicationException(404);
    }


    public void createUser(final UserEntityCreate userToCreate) {
        System.out.println(userToCreate);
        System.out.println(userToCreate.toDaoEntity());
        try{
               em.persist(userToCreate.toDaoEntity());
        }catch (Exception e ){
            em.persist(userToCreate.toDaoEntity());
        }

    }

    public void updateUser(final UserEntityDao user , final long id){
        if(user.getId() != 0 && id == user.getId() ) {
            UserEntityDao result = em.find(UserEntityDao.class , id);
            result.updatePropertiesDao(user);
            em.merge(result);
        }
        else throw new IllegalArgumentException("there is no Id ");
    }

    public void updateThePassword(final String altPassword , final UserEntityDao user , final long id){

        if(user.getId() != 0 && id == user.getId()){
            UserEntityDao userFromDatabase = em.find(UserEntityDao.class , id);
            if (!altPassword.equals(userFromDatabase.getPassword()))throw new IllegalArgumentException("wrong password");
            userFromDatabase.updateThePassword(user);
        }
        else throw new IllegalArgumentException("there is no Id ");
    }

    public void deleteUser(final  long id ){
        UserEntityDao user = em.find(UserEntityDao.class , id);
        em.remove(user);
    }


}
