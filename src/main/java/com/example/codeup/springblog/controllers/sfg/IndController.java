package com.example.codeup.springblog.controllers.sfg;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndController {

    @GetMapping("/ind")
    public String getIndex() {
        return "ind";
    }
}