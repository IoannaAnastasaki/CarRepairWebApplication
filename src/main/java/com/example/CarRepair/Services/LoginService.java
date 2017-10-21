package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;

import javax.naming.AuthenticationException;

public interface LoginService {

    User login(String email,String password) throws AuthenticationException;

    void logout(String email) throws Exception;
}
