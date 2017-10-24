package com.example.CarRepair.Controller;

import com.example.CarRepair.Converter.RepairConverter;
import com.example.CarRepair.Converter.UserConverter;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Domain.User;
import com.example.CarRepair.Model.NewRepairForm;
import com.example.CarRepair.Model.NewUserForm;
import com.example.CarRepair.Services.OwnerService;
import com.example.CarRepair.Services.RepairService;
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
public class NewRepairController {
    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(NewUserController.class);
    private static final String CREATE_REPAIR_FORM = "newRepairForm";

    @Autowired
    private OwnerService userService;

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/admin/createRepair", method = RequestMethod.GET)
    public String createRepair(Model model) {
        model.addAttribute(CREATE_REPAIR_FORM, new NewRepairForm());
        return "admin/createRepair";
    }


    @RequestMapping(value = "/admin/createRepair", method = RequestMethod.POST)
    public String createRepair(@Valid @ModelAttribute(CREATE_REPAIR_FORM)
                                           NewRepairForm CreateRepairForm,
                             BindingResult bindingResult, HttpSession session,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            //error handling
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "admin/createRepair";
        }

        try {
            User user = userService.findByTaxNumber(Integer.parseInt(CreateRepairForm.getTaxNumber()));
            if (user==null){
                redirectAttributes.addFlashAttribute("errorMessage", "User does not exist");
                return "admin/createUser";
            }
            Repair repair = RepairConverter.buildRepairObject(CreateRepairForm ,user);
            repairService.CreateRepair(repair);

        } catch (Exception exception) {
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("Repair creation failed: " + exception);
            return "redirect:/admin/createUser";
        }


        redirectAttributes.addFlashAttribute("message", "You have sucessfully create a repair");
        return "redirect:/admin/admH";


    }
}

