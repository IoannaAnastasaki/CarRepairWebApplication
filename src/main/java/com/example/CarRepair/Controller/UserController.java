package com.example.CarRepair.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
    private static final String UserData = "name";

    @RequestMapping(value = "/userInfo",method = RequestMethod.GET)
    public String userInfo(Model model){
        addUsernameInModel(model);
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
