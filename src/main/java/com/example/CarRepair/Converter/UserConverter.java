package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;

public class UserConverter {
    /**
     * When the admin put field in users from must be adapted to out user from domain to save this user in our
     * database. So we need this method to control thos
     * @param createUserForm the data we take form our form
     * @return User a object in our domain to save it in Database
     */
    public static User buildUserObject(NewUserForm createUserForm) {
        User user = new User();
        try {
            //get it field one by one, use try cause tax number is a number only
            user.setLastName(createUserForm.getLastname());
            user.setFirstName(createUserForm.getFirstname());
            user.setAddress(createUserForm.getAddress());
            user.setEmail(createUserForm.getMail());
            user.setPassword(createUserForm.getPassword());
            //if tax number is not arithmetic it throws and exception
            user.setTaxNumber(Integer.parseInt(createUserForm.getTaxNumber()));
            /*type can have 2 values taken by radio ADMIN or USER if it is Admin then isadmin is 1
             *else isadmin is 0
             */
            if (createUserForm.getType().equals("ADMIN")){
                user.setAdmin(true);
            }else{
                user.setAdmin(false);
            }
            return user;
        }
        catch (NumberFormatException ex){
            System.err.println("Tax number must be sequence of 9 numbers. User " +user.getEmail()+" has not");
            //is there is an error it tax no (we have regex to avoid) we return null and we put nothing in our database
            return null;
        }
    }

}
