package com.example.CarRepair.Repositories;

import com.example.CarRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    //Taxno,Lastname,Firstname,Address,Email,Userpassword,Isadmin

    //taxno,lastname,firstname,address,email,userpassword,isadmin)
    //login query
    User findByEmailAndUserpassword(String email,String userpassword);
    //create query
    User save(User user);
    User findByTaxNumber(Integer taxNumber);
    User findByEmail(String email);
    User findByTaxNumberOrEmail(Integer taxNumber, String email);
    User findByUserID(Long userID);

    void delete(User user);
   /* When we do save we do also update if our user is new it make a new one otherwise it update the existed
    public <S extends T> S save(S entity) {

        if (entityInformation.isNew(entity)) {
            em.persist(entity);
            return entity;
        } else {
            return em.merge(entity);
        }
    }
    */

}