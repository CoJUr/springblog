//package com.example.codeup.springblog.controllers;
//
////package com.example.codeup.gospringblog.controller;
//
//
//import com.example.codeup.springblog.services.DogFactsAPISvc;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class DogAPIExample {
//
//    private DogFactsAPISvc dogFactApiSvc;
//
//    public DogAPIExample(DogFactsAPISvc dogFactApiSvc) {
//        this.dogFactApiSvc = dogFactApiSvc;
//    }
//
//    @GetMapping("/api/dog/fact")
//    @ResponseBody
//    public String randomDogFact() {
//        return dogFactApiSvc.getDogFact();
//    }
//
//}