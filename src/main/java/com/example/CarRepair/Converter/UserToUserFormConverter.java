package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Model.UserUpdateForm;

public class UserToUserFormConverter {


//pairnei dedomena apo to xrhsth kai ta vazei se mia forma.Epistrefei th forma


    public static UserUpdateForm convert(User user) {
        UserUpdateForm userForm = new UserUpdateForm();
        userForm.setFirstname(user.getFirstName());
        userForm.setLastname(user.getLastName());
        userForm.setAddress(user.getAddress());
        userForm.setMail(user.getEmail());
        userForm.setPassword(user.getPassword());
        userForm.setTaxNumber(Integer.toString(user.getTaxNumber()));
        userForm.setUserId(user.getUserID());


        if (user.isAdmin() == true) {
            userForm.setType("ADMIN");
        } else if (user.isAdmin() == false) {
            userForm.setType("USER");
        }
        return userForm;
    }
}


