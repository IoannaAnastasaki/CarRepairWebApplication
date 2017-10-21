package com.example.CarRepair.Controller;

import com.example.CarRepair.Model.LoginForm;
import com.example.CarRepair.Services.LoginServiceImpl;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private static final String LoginForm = "loginForm";
    private final static org.slf4j.Logger LOG = LoggerFactory.getLogger(LoginServiceImpl.class);


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String login(Model model,
                        @RequestParam(name = "error", required = false) String error,
                        HttpSession session) {

        if (error != null) {
            LOG.error("User not found!");
            model.addAttribute("errorMessage", "User not found! Please try again");
        }
        model.addAttribute(LoginForm, new LoginForm());
        
        return "login";
    }

}
