package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Repositories.RepairRepository;
import com.example.CarRepair.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private RepairRepository repairRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<Repair> findByUser(User user) {

        return repairRepository.findByUser(user);
        //return  repairRepository.findByUser(userId);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
