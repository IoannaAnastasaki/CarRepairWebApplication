package com.example.CarRepair.Controller;
import java.util.List;
import javax.servlet.http.HttpSession;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.CarRepair.Services.OwnerService;
import com.example.CarRepair.Model.SearchUserForm;
import com.example.CarRepair.Model.UserForm;
import com.example.CarRepair.Converter.UserToUserForm;
import com.example.CarRepair.Domain.User;

@Controller
public class SearchUserController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(NewUserController.class);
    private static final String SEARCH_FORM = "searchUserForm";
    public static final String USER_DETAILS = "userForm";

    @Autowired
    private OwnerService userService;

    @RequestMapping(value = "/admin/findUser", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchUserForm());
        return "/admin/findUser";
    }

    @RequestMapping(value = "/admin/findUser", method = RequestMethod.POST)
    public String search(@ModelAttribute(SEARCH_FORM) SearchUserForm searchForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {
        User user=null;
        UserForm userDetail=null;
        try {
            user = userService.SearchUser(searchForm.getSearchInput());
            if (user == null) {
                redirectAttributes.addFlashAttribute("errorMessage", "No user found");

            }
        }catch(Exception exception){
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("User creation failed: " + exception);
            return "redirect:/admin/findUser";
        }
        userDetail = UserToUserForm.TypeCastUser(user);
        redirectAttributes.addFlashAttribute(USER_DETAILS, userDetail);
        return "redirect:/admin/findUser";
    }


//    @RequestMapping(value = "/search/all", method = RequestMethod.GET)
//    public ResponseEntity<List<UserForm>> search() {
//        ResponseEntity responseEntity = new ResponseEntity(userService.findAll(), HttpStatus.OK);
//        return responseEntity;
//    }

}
