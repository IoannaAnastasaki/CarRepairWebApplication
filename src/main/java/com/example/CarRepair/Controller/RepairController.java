package com.example.CarRepair.Controller;


import com.example.CarRepair.Model.RepairRow;
import com.example.CarRepair.Services.RepairListImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class RepairController
{
    @Autowired
    private RepairListImp repairListImp;



    @RequestMapping(value = "admin/admH", method = RequestMethod.GET)
    public ResponseEntity<List<RepairRow>> getListOfRepairs()
    {
        List<RepairRow> serviceList = repairListImp.findTop10ByOrderByDayOfRepair();
        return new ResponseEntity<>(serviceList, HttpStatus.OK);
    }


}
