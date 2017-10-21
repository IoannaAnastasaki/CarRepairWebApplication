package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.UserExistException;
import com.example.CarRepair.Repositories.UserRepository;
import com.example.CarRepair.Services.OwnerService;
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
}
