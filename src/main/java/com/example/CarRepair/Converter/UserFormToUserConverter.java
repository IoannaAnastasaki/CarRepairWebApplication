package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.User;

import com.example.CarRepair.Model.UserUpdateForm;


public class UserFormToUserConverter

{

//pairnei dedomena apo forma kai ta eisagei se enan xrhsth.Epistrefei ton xrhsth

public static User convert(UserUpdateForm userForm, User retrieveUser)
{

    retrieveUser.setFirstName(userForm.getFirstname());
    retrieveUser.setAddress(userForm.getAddress());
    retrieveUser.setLastName(userForm.getLastname());
    retrieveUser.setEmail(userForm.getMail());
    retrieveUser.setPassword(userForm.getPassword());
    retrieveUser.setTaxNumber(Integer.parseInt(userForm.getTaxNumber()));

        if (userForm.getType().equals("ADMIN")) {
        retrieveUser.setAdmin(true);
        } else if (userForm.getType().equals("USER") ) {
        retrieveUser.setAdmin(false);}

 return retrieveUser;

}
}
