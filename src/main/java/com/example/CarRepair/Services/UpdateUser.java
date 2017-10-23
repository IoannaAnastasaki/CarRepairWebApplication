package com.example.CarRepair.Services;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;

import java.util.List;

public interface UpdateUser
{

    NewUserForm patchBookById(Long id, NewUserForm userForm);
    public NewUserForm findUser(Long userID);

}



