package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;

//makes the class a controller
@Controller
public class HelloController {
//    establish url pattern
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("/test")
    @ResponseBody
    public String test() {

        return "This is a different mapping!";
    }

    @RequestMapping("/increment/{number}")
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

//    @RequestMapping("/showForm")
//    public String showForm() {
//        return "helloworld-form";
//    }
//
//    @RequestMapping("/processForm")
//    public String processForm(HttpRequest request, Model model) {
//        return "helloworld.jsp";
//    }
}
