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

            //if tax number is not arithmetic it throws and exception


            repair.setUser(user);
            /* Maybe its from github see thee to do as something so to avoid any conflicts to
             * i show it as pending so now i set it corect
             */
            repair.setPlateNumber(createRepairForm.getPlateNumber());
            repair.setDescription(createRepairForm.getDescription());

            //repairDate
            /* SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.EN_US);
             * Date date = sdf.parse("Mon Mar 14 16:02:37 GMT 2011"));// all done
             * */
            // KAPOY EDW EXW KANEI TIN VLAKIA KAI DEN EINAI STRING TIPE H DATE TOU CALEDAR >.<
            repair.setDayOfRepair(setExpireDate(createRepairForm.getRepairDate()));
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
            //is there is an error it tax no (we have regex to avoid) we return null and we put nothing in our database
            return null;
        }
    }

    public static Date setExpireDate(String CalledarDate) {
        Date databaseDate;
        String[] parts = CalledarDate.split("/");
        if (parts.length==3){
            try{
                //Split the string in / so I take year month and day of month
                int year=Integer.parseInt(parts[2]);
                int month=Integer.parseInt(parts[0]);
                int day=Integer.parseInt(parts[1]);
                //System.out.println("mera "+parts[0] +" minas "+parts[1]+" etos "+parts[2] );
                databaseDate=new Date(year, month, day);
                return databaseDate;

                //Catch a exception if a part of my string its not a number
            } catch (NumberFormatException ex) {
                System.err.println("You can not have alphabet letters in a date.");
                return null;
                //catch an exception if the date does not excist for example 31/11/2017
            }catch (DateTimeException e) {
                System.err.println("There is no such a day in the calendar.");
                return null;
            }
        }
        return null;

    }

}
