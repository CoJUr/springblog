package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
    @GetMapping("/test2")
    public String returnTest(Model zModel) {
        zModel.addAttribute("myname", "cory");
        return "first-view";
    }

    @GetMapping("/favcity")
    public String returnFavCity(Model xModel) {
        return "favcity";
    }

    @PostMapping("/favcity")
    public String processFavCity(String city, Model xModel) {
        xModel.addAttribute("city", city);
        return "favcity-result";
    }




    }

