package com.example.SoloTune.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/panelAdmin")
    public String panelAdmin(){
        return "panelAdmin";
    }

}
