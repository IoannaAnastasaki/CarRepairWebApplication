package com.example.CarRepair.Controller;

import javax.servlet.http.HttpSession;



import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.CarRepair.Services.RepairService;
import com.example.CarRepair.Model.SearchRepairForm;
import com.example.CarRepair.Model.RepairForm;


import java.util.List;

@Controller
public class SearchRepairController {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(SearchRepairController.class);
    private static final String SEARCH_FORM = "searchRepairForm";
    public static final String REPAIR_DETAILS = "repairs";

    @Autowired
    private RepairService repairService;


    @RequestMapping(value = "/admin/findRepair", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute(SEARCH_FORM, new SearchRepairForm());
        return "/admin/findRepair";
    }

    @RequestMapping(value = "/admin/findRepair", method = RequestMethod.POST)
    public String search(@ModelAttribute(SEARCH_FORM) SearchRepairForm searchRepairForm,
                         HttpSession session,
                         RedirectAttributes redirectAttributes) {
        List<RepairForm> repairs;
        try {
            repairs=repairService.SearchRepair(searchRepairForm.getTaxNumber(),searchRepairForm.getPlateNumber(),searchRepairForm.getStartDate(),searchRepairForm.getEndDate());
            if (repairs.isEmpty()){
                redirectAttributes.addFlashAttribute("errorMessage", "Repairs Not Found");
            }
            redirectAttributes.addFlashAttribute(REPAIR_DETAILS, repairs);
            //model.addAttribute(REPAIR_DETAILS,repairs);

        }catch(Exception exception){
            //if an error occurs show it to the user
            redirectAttributes.addFlashAttribute("errorMessage", exception.getMessage());
            logger.error("Search Repair Fail: " + exception);
            return "redirect:/admin/findRepair";
        }
        return "redirect:/adm" +
                "in/findRepair";
    }
}
