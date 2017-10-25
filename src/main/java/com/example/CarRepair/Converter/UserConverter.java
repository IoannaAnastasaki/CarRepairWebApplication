package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;

public class UserConverter {


    public static User buildUserObject(NewUserForm createUserForm) {
        User user = new User();
        try {
            user.setLastName(createUserForm.getLastname());
            user.setFirstName(createUserForm.getFirstname());
            user.setAddress(createUserForm.getAddress());
            user.setEmail(createUserForm.getMail());
            user.setPassword(createUserForm.getPassword());
            user.setTaxNumber(Integer.parseInt(createUserForm.getTaxNumber()));
            if (createUserForm.getType().equals("ADMIN")){
                user.setAdmin(true);
            }else{
                user.setAdmin(false);
            }
            return user;
        }
        catch (NumberFormatException ex){
            System.err.println("Tax number must be sequence of 9 numbers. User " +user.getEmail()+" has not");
            return null;
        }
    }

}
