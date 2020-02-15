package com.example.CarRepair.Controller;


import com.example.CarRepair.Model.RepairRow;
import com.example.CarRepair.Services.RepairListImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RepairController
{
    @Autowired
    private RepairListImp repairListImp;
    private static final String REPAIR_lIST_TOP10_DATA = "repairTop10";


    //edw dhmioyrgoyme th lista me formes repair row(kathe forma exei mia
    //eggrafh gia repair.Syndew to ftl me th lista mesw tou model.
    //Epistrefw auto to ftl wste na dw th selida m sto view

    @RequestMapping(value = "/admin/admH", method = RequestMethod.GET)
    public String repairListTop10(Model model)
    {
        List<RepairRow> serviceList = repairListImp.findTop10ByOrderByDayOfRepair();
        model.addAttribute(REPAIR_lIST_TOP10_DATA,serviceList);
                return "admin/admH";
    }



//    @RequestMapping(value = "admin/admH", method = RequestMethod.GET)
//    public ResponseEntity<List<RepairRow>> getListOfRepairs()
//    {
//        List<RepairRow> serviceList = repairListImp.findTop10ByOrderByDayOfRepair();
//        return new ResponseEntity<>(serviceList, HttpStatus.OK);
//    }


}
