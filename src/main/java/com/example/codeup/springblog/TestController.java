package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
    @GetMapping("/test2")
    public String returnTest(Model zModel) {
        zModel.addAttribute("myname", "cory");
        return "first-view";
    }
}
