package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.UserExistException;
import com.example.CarRepair.Exceptions.UserNotExistException;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void CreateUser(User user) throws Exception {
        User retrievedUser=userRepository.findByTaxNumberOrEmail(user.getTaxNumber(),user.getEmail());
        if (retrievedUser!=null) {
            throw new UserExistException("User already exist");
        }
        else {
            retrievedUser = userRepository.save(user);
        }
    }

    @Override
    public User findByTaxNumber(Integer taxNumber) throws Exception{
        User retrievedUser=userRepository.findByTaxNumber(taxNumber);
        if (retrievedUser==null) {
            throw new UserNotExistException("User Not already exist");
        }
        else {
            return retrievedUser;
        }
    }
}
