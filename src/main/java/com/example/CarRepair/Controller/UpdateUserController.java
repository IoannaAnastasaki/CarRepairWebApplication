package com.example.CarRepair.Controller;

import com.example.CarRepair.Converter.UserFormToUserConverter;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.UserUpdateForm;
import com.example.CarRepair.Services.UpdateUserImpl;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UpdateUserController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(NewUserController.class);
    //h forma pou exei auto to id sto ftl toy updateUser
    private static final String UPDATE_USER_FORM = "updateForm";
    private static final String UPDATED_READY_USER_FORM = "updatedReadyUserForm";


    //bean toy service
    @Autowired
    UpdateUserImpl updateService;


    //methodos gia na ferw ta dedomena toy xrhsth(prin ginei update) mprosta sto view
    @RequestMapping(value = "/admin/updateUser/{userID}", method = RequestMethod.GET)
    public String getUserData(@PathVariable Long userID, Model model)

    {
        UserUpdateForm userForm = updateService.findUser(userID);
        //ginetai binding metaksu ftl kai ths formas pou tha parw kalwntas ayth th methodo apo to service
        model.addAttribute(UPDATE_USER_FORM, userForm);
        //epistrefei to ftl me ta data ths formas
        return "admin/updateUser"; /*redirect:/UpdateUser*/

    }



    //epistrefei mia ananeomenh forma me ta updated stoixeia toy xrhsth

    @RequestMapping(value = "/admin/updateUser/{userID}", method = RequestMethod.POST)
    public String UpdatedUser(@Valid @ModelAttribute(UPDATE_USER_FORM)
                                          UserUpdateForm userForm, BindingResult bindingResult, HttpSession session,
                              RedirectAttributes redirectAttributes, @PathVariable Long userID, Model model)
    {

        if (bindingResult.hasErrors())
        {
            //error handling
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "/admin/updateUser/";
        }

        try
        {
           //pernaei ta dedomena apo th forma se user me to id poy exoume dwsei
            User updateUser= UserFormToUserConverter.convert(userForm,updateService.findOne(userID));
           //apothikeuoyme ton updated user
            updateService.UpdateUser(updateUser);



        }
        catch (Exception exception)
        {

            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            logger.error("User update failed: " + exception);
            return "redirect:/admin/updateUser/{userID}";

        }

        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed update functionality");
        return "redirect:/admin/admH";

    }


}

