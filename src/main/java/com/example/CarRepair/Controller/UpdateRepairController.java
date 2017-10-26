package com.example.CarRepair.Controller;


import com.example.CarRepair.Converter.RepairFormToRepairConverter;
import com.example.CarRepair.Domain.Repair;
import com.example.CarRepair.Model.RepairUpdateForm;
import com.example.CarRepair.Services.UpdateRepairImpl;
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
public class UpdateRepairController
{


    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(NewUserController.class);
    //h forma pou exei auto to id sto ftl toy updateUser
    private static final String UPDATE_REPAIR_FORM = "repairForm";


    //bean toy service
    @Autowired
    UpdateRepairImpl repairService;


    //methodos gia na ferw ta dedomena toy repair(prin ginei update) mprosta sto view
    @RequestMapping(value = "/admin/updateRep/{repairID}", method = RequestMethod.GET)
    public String getRepairData(@PathVariable Long repairID, Model model)

    {
        RepairUpdateForm repairForm = repairService.findRepair(repairID);
        //ginetai binding metaksu ftl kai ths formas pou tha parw kalwntas ayth th methodo apo to service
        model.addAttribute(UPDATE_REPAIR_FORM, repairForm);
        //epistrefei to ftl me ta data ths formas
        return "admin/updateRep";

    }



    //epistrefei mia ananeomenh forma me ta updated stoixeia toy repair

    @RequestMapping(value = "/admin/updateRep/{repairID}", method = RequestMethod.POST)
    public String UpdatedRepair(@Valid @ModelAttribute(UPDATE_REPAIR_FORM)
                                      RepairUpdateForm repairForm, BindingResult bindingResult, HttpSession session,
                                RedirectAttributes redirectAttributes, @PathVariable Long repairID, Model model)
    {

        if (bindingResult.hasErrors())
        {
            //error handling
            logger.error(String.format("%s Validation Errors present: ", bindingResult.getErrorCount()));
            return "/admin/updateRep/";
        }

        try
        {
            //pernaei ta dedomena apo th forma se repair me to id poy exoume dwsei
            Repair updateRepair= RepairFormToRepairConverter.convert(repairForm,repairService.findOneRepair(repairID));
            //apothikeuoyme ton updated user
            repairService.UpdateRepair(updateRepair);



        }
        catch (Exception exception)
        {

            redirectAttributes.addFlashAttribute("error", exception.getMessage());
            logger.error("Repair update failed: " + exception);
            return "redirect:/admin/updateRep/{repairID}";

        }

        redirectAttributes.addFlashAttribute("message", "You have sucessfully completed update functionality");
        return "redirect:/admin/admH";

    }





}
