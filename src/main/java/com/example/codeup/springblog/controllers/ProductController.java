package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    // dependency injection
    private ProductRepository productDao;
    private PostRepository postDao;

    public ProductController(ProductRepository productDao, PostRepository postDao) {
        this.productDao = productDao;
        this.postDao = postDao;
    }

    // get all records with JPA
    @GetMapping("/products")
    public String showAllProducts(Model vModel) {
        List<Product> productList = productDao.findAll();
        // pass products to view
        vModel.addAttribute("products", productList);
        return "products/index";
    }

    @GetMapping("/products/create")
    // Model is the data model we want to pass to the html page.
    public String createProducts(Model model) {
        model.addAttribute("newProduct", new Product());
        return "products/create";
    }

    @PostMapping("/products/create")
    // Model Attribute is the object that is submitted from the form.
    public String submitProduct(@ModelAttribute Product product) {
        productDao.save(product);
        return "redirect:/products";
    }

    // delete a record with JPA
    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productDao.deleteById(id);
        return "redirect:/products";
    }

    // getting a specific record with JPA
    @GetMapping("/products/test/{id}")
    public String getProduct(@PathVariable long id) {
        Product p = productDao.findById(id).get();
        System.out.println(p);
        return "redirect:/products";
    }

    @GetMapping("/derived/1")
    @ResponseBody
    public List<Product> getProductsAfterId() {
        return productDao.getProductsByIdAfter(6L);
    }

    @GetMapping("/derived/2")
    @ResponseBody
    public List<Product> getBirdProducts() {
        return productDao.getProductByNameEndsWithIgnoreCase("bird");
    }

    @GetMapping("/derived/3")
    @ResponseBody
    public Product getProductByPrice() {
        return productDao.getFirstByPriceInCents(55);
    }

    @GetMapping("/test/jpql")
    @ResponseBody
    public List<String> getProductFirstName() {
        return productDao.getProductNamesNative();
    }

}
