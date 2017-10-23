package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Exceptions.UserExistException;
import com.example.CarRepair.Repositories.RepairRepository;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UpdateUserImpl
{

    @Autowired
    private UserRepository userRepository;

//auto logika den xreiazetai giati to kseroyme hdh apo to search

    //kseroume oti o xrhsths uparxei
    //ara mporoume apla na kanoyme update ola ta stoixeia t
    //kai na ta valoyme sth thesi p htan analoga me to id
    //mporoume na allaksoume to afm h to email(h kai ta 2)?
    public void UpdateUser(User user) throws Exception {
        User updateUser=userRepository.findByTaxNumberOrEmail(user.getTaxNumber(),user.getEmail());
        if (updateUser==null) //user doesnt exist
        {
           //throw exception UserAlreadyExist();

        }
        else //user  exist
            {




                // updateUser = userRepository.save(user);
            }




    }

}
