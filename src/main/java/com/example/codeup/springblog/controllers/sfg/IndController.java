package com.example.codeup.springblog.controllers.sfg;

import com.example.codeup.springblog.services.ProdServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndController {

    private ProdServiceInt productServiceInt;

    @Autowired
    public void setProductServiceInt(ProdServiceInt productServiceInt) {
        this.productServiceInt = productServiceInt;
    }

    @GetMapping("/ind")
    public String getIndex(Model model) {

//        bind the list of products to the model
        model.addAttribute("products", productServiceInt.listProducts());
        return "ind";
    }
}
