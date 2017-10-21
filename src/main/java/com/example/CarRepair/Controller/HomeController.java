package com.example.CarRepair.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    String demoPage() {
        return "redirect:/login";
    }
}