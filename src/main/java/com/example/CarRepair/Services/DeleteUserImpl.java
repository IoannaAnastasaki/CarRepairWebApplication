package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Repositories.RepairRepository;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DeleteUserImpl implements DeleteUser{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void delete(Long userID) {
            userRepository.delete (userID);
    }


}
