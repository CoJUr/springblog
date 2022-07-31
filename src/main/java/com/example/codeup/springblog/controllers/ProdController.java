package com.example.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProdController {
    @GetMapping("/prod")
    public String getProduct() {
        return "prod";
    }
}
