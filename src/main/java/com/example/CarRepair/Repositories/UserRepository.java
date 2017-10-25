package com.example.CarRepair.Repositories;

import com.example.CarRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {


    User findByEmailAndUserpassword(String email,String userpassword);
    //create query
    User save(User user);
    User findByTaxNumber(Integer taxNumber);
    User findByEmail(String email);
    User findByTaxNumberOrEmail(Integer taxNumber, String email);

   // User findByUserID(Long userID);
   User findByUserID(Long userID);


    // List<User> findByUserID(Long userID);

   // Optional<User> findByUserID(Long id);

   // User findUser(Long userID);
}