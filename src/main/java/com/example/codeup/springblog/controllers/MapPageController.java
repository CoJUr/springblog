package com.example.codeup.springblog.controllers;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MapPageController {

    @Value("${mapbox_api_token}")
    private String mapBoxToken;

    @GetMapping("/map")
    public String returnMapView(Model vModel) {
        vModel.addAttribute("mapboxToken", mapBoxToken);
        return "mapbox-example";
    }

}