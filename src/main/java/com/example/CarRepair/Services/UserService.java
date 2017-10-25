package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;

import java.util.List;


public interface UserService {

    List<Repair> findByUser(User user);
    User findByEmail(String email);
}
