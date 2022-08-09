package com.example.codeup.springblog.controllers.sfg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.codeup.springblog.services.ProdServiceInt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProdController {

    private ProdServiceInt productServiceInt;

//    setter based dependency injection
    @Autowired
    public void setProductServiceInt(ProdServiceInt productServiceInt) {
        this.productServiceInt = productServiceInt;
    }


    @GetMapping("/prod")
    public String getProduct() {
        return "redirect:ind";
//        just return the list of products if they dont specify an id
    }

    @RequestMapping("/prod/{id}")
    public String getProductById(@PathVariable Integer id, Model model) {

        model.addAttribute("product", productServiceInt.getProduct(id));
        return "prod";
    }
}
