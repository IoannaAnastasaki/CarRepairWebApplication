package com.example.CarRepair.Repositories;

import com.example.CarRepair.Domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

    User findByEmailAndUserpassword(String email,String userpassword);
    User save(User user);
    User findByTaxNumber(Integer taxNumber);
    User findByEmail(String email);
    User findByTaxNumberOrEmail(Integer taxNumber, String email);
    User findByUserID(Long userID);

    void delete(User user);

}