package com.example.codeup.springblog;

import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

//    dependency injection!
    private ProductRepository productDao;

    public ProductController(ProductRepository productDao) {
        this.productDao = productDao;
    }

//    get all records with JPA
    @GetMapping("/products")
    public String showAllProducts(Model model) {
        List<Product> productsList = productDao.findAll();

            //        List<Product> productsList = new ArrayList<>(Arrays.asList(
            //                new Product("Hammer", 1000),
            //                new Product("Nail", 100),
            //                new Product("Screwdriver", 200),
            //                new Product("Wrench", 300)
            //        ));

//        passing products array to view
        model.addAttribute("products", productsList);
        return "products/index";
    }


    //    save and create a product with JPA
    @GetMapping("/products/create")
    public String createProducts(Model model) {
        model.addAttribute("newProduct", new Product());

        return "products/create";
    }

    @PostMapping("/products/create")
    public String submitProduct(@ModelAttribute Product product) {

        productDao.save(product);
        return "redirect:/products";
    }

//    delete a record with jpa
//    @PostMapping("/products/delete/{id}")
//    public String deleteProduct(@PathVariable long id) {
//        productDao.deleteById(id);
//        return "redirect:/products";
//    }


    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable long id) {
        productDao.deleteById(id);
        return "redirect:/products";
    }


//    show/get a specific record with JPA
    @GetMapping("/products/test/{id}")
    public String getProduct(@PathVariable long id) {
        productDao.findById(id).get();
        return "redirect:/products";
    }


//    @GetMapping("/objects")
//    public List<Product> getObjects() {
//        return productDao.findAll();
//    }
//
//    @GetMapping("/admins")
//    public List<Product> admins() {
//        new RestTemplate().getForObject("http://localhost:8080/products", Product[].class);
//
//        return productDao.findAll();
////         see in "http-client" type
//    }


}
