package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExController {
@GetMapping("/helloworld")
    public String returnHelloWorld(Model vModel) {
    vModel.addAttribute("name", "Justin");
        return "hello-world";
    }
}
