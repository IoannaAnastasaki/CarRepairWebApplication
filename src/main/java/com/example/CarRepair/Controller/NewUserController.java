package com.example.CarRepair.Controller;

import com.example.CarRepair.Converter.UserConverter;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Services.OwnerService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
public class NewUserController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(NewUserController.class);
    private static final String CREATE_USER_FORM = "newUserForm";

    @Autowired
    private OwnerService userService;

    @RequestMapping(value = "/admin/createUser", method = RequestMethod.GET)
    public String createUser(Model model) {
        model.addAttribute(CREATE_USER_FORM, new NewUserForm());
        return "admin/createUser";
    }


    @RequestMapping(value = "/admin/createUser", method = RequestMethod.POST)
    public String createUser(@Valid @ModelAttribute(CREATE_USER_FORM)
                                     NewUserForm CreateUserForm,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            //error handling
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "admin/createUser";
        }

        try {
            User user = UserConverter.buildUserObject(CreateUserForm);
            if (user == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "User already exist");

            }
            userService.CreateUser(user);

        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("User creation failed: " + exception);
            return "redirect:/admin/createUser";
        }


        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed registration");
        return "redirect:/admin/admH";


    }
}
