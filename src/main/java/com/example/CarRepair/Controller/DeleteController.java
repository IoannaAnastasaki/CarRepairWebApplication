package com.example.CarRepair.Controller;

import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Services.DeleteRepairImpl;
import com.example.CarRepair.Services.DeleteUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DeleteController {

    private static final String DELETE_USER = "redirect:/admin/admH";

    @Autowired
    DeleteUserImpl updateService;

    @RequestMapping(value = "/admin/deleteUser/{userID}", method = RequestMethod.POST)
    public String deleteUserId(@PathVariable Long userID) {
        updateService.delete(userID);
        return DELETE_USER;


    }

    private static final String DELETE_REPAIR = "redirect:/admin/admH";

    @Autowired
    DeleteRepairImpl deleteRepairService;

    @RequestMapping(value = "/admin/deleteRep/{repairID}", method = RequestMethod.POST)
    public String deleteRepairId(@PathVariable Long repairID) {
        deleteRepairService.delete(repairID);
        return DELETE_REPAIR;
    }
}
