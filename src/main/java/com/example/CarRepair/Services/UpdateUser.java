package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;

import java.util.List;

public interface UpdateUser
{

  //  User updateUserById(Long userID, NewUserForm userForm);
  User UpdateUser(Long userID,NewUserForm userForm) throws Exception;
    public NewUserForm findUser(Long userID);

}



