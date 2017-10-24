package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Model.UserUpdateForm;

import java.util.List;

public interface UpdateUser
{

  //  User updateUserById(Long userID, NewUserForm userForm);
  void UpdateUser(User user) throws Exception;
    public UserUpdateForm findUser(Long userID);
    public User findOne(Long userID);
}



