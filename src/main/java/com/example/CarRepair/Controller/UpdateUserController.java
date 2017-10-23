package com.example.CarRepair.Controller;

import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Services.UpdateUserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UpdateUserController
{

    //h forma pou exei auto to id sto ftl toy updateUser
    private static final String UPDATE_USER_FORM = "updateForm";

    //bean toy service
    @Autowired
    UpdateUserImpl updateService;


    //methodos gia na ferw ta dedomena toy xrhsth(prin ginei update) mprosta sto view
    @RequestMapping(value = "/admin/updateUser/{userID}", method = RequestMethod.GET)
    public String getUserData (@PathVariable Long userID,Model model)

    {       //ginetai binding metaksu ftl kai ths formas pou tha parw kalwntas ayth th methodo apo to service
            model.addAttribute(UPDATE_USER_FORM, updateService.findUser(userID));
            //epistrefei to ftl me ta data ths formas
            return "updateUser";

    }


    //epistrefei mia ananeomenh forma me ta updated stoixeia toy xrhsth(sto try)
    //alliws vgazei to status tou Bad Request
    @RequestMapping(value = "/admin/updateUser/{userID}", method = RequestMethod.PATCH)
    public ResponseEntity<NewUserForm> patchUser(@PathVariable("userID") Long id, @RequestBody NewUserForm userForm) {
        try {
            NewUserForm updatedUser = updateService.patchBookById(id, userForm);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }




}
