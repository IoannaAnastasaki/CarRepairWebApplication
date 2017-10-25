package com.example.CarRepair.Converter;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.NewRepairForm;
import com.example.CarRepair.Repositories.UserRepository;

import java.time.DateTimeException;
import java.util.Date;

public class RepairConverter {
    public static Repair buildRepairObject(NewRepairForm createRepairForm, User user) {
        Repair repair = new Repair();

        UserRepository userRepository;

        try {


            repair.setUser(user);

            repair.setPlateNumber(createRepairForm.getPlateNumber());
            repair.setDescription(createRepairForm.getDescription());


            repair.setDayOfRepair(createRepairForm.getRepairDate());

            if (createRepairForm.getRepairStatus().equals("Pending")){
                repair.setRepairStatus("ToDo");
            }else{
                repair.setRepairStatus(createRepairForm.getRepairStatus());
            }

            repair.setRepairType(createRepairForm.getRepairType());

            repair.setServiceCost(Double.parseDouble(createRepairForm.getCost()));

            return repair;
        }
        catch (NumberFormatException ex){
            System.err.println("Check out your filed and give number to tax number and double to cost");
            return null;
        }
    }

}
