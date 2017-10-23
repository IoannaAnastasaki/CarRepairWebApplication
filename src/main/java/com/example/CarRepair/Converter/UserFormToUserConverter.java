package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Model.UserRow;
import org.springframework.security.core.AuthenticationException;

public class UserFormToUserConverter

{

//pairnei dedomena apo forma kai ta eisagei se enan xrhsth.Epistrefei ton xrhsth

public static User convert(NewUserForm userForm,User retrieveUser)
{

    retrieveUser.setFirstName(userForm.getFirstname());
    retrieveUser.setAddress(userForm.getAddress());
    retrieveUser.setLastName(userForm.getLastname());
    retrieveUser.setEmail(userForm.getMail());
    retrieveUser.setPassword(userForm.getPassword());
    retrieveUser.setTaxNumber(Integer.parseInt(userForm.getTaxNumber()));

        if (userForm.getType() == "ADMIN") {
        retrieveUser.setAdmin(true);
        } else if (userForm.getType() == "USER") {
        retrieveUser.setAdmin(false);}

 return retrieveUser;

}
}
//
//    RepairRow repairRow = new RepairRow();
//        repairRow.setDayOfRepair(repair.getDayOfRepair());
//                repairRow.setDescription(repair.getDescription());
//                repairRow.setPlateNumber(repair.getPlateNumber());
//                repairRow.setRepairStatus(repair.getRepairStatus());
//                repairRow.setServiceCost(repair.getServiceCost());
//                repairRow.setRepairType(repair.getRepairType());
//                repairRow.setTaxNumber(repair.getUser().getTaxNumber());
//                return repairRow;