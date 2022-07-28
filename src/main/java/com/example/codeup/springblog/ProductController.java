package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String showAllProducts(Model model) {

        List<Product> productsList = new ArrayList<>(Arrays.asList(
                new Product("Hammer", 1000),
                new Product("Nail", 100),
                new Product("Screwdriver", 200),
                new Product("Wrench", 300)
        ));

        model.addAttribute("products", productsList);

        return "products/index";
    }




}
