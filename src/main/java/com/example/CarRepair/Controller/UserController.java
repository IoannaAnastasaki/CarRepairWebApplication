package com.example.CarRepair.Controller;

import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class UserController {
    private static final String UserData = "email"; //user email
    private static final String REPAIR_DATA = "repairs";
    private static final String USER = "user";
    private UserService userService;

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String userInfo(Model model){

        //addUsernameInModel(model);

        //System.out.println(USER_EMAIL);
        User user = userService.findByEmail("papado@yahoo.com");
        //List<Repair> repairList = userService.findByUser(2);
        List<Repair> repairList = userService.findByUser(user);

        model.addAttribute(REPAIR_DATA,repairList);
        model.addAttribute(USER,user);
        return "userInfo";
    }

    private void addUsernameInModel(Model model) {
        Authentication auth =
                SecurityContextHolder.getContext().getAuthentication();

        if (auth != null) {
            String email = (String) auth.getPrincipal();
            model.addAttribute(UserData, email);
        } else {
            model.addAttribute("errorMessage", "User not logged in anymore!");
        }
    }


}
