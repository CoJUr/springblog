//package com.example.codeup.springblog.services;
//
//import com.example.codeup.springblog.Domain.Author;
//import com.example.codeup.springblog.Domain.ProductCategory;
//import com.example.codeup.springblog.Product;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Service
//public class ProdServiceImplement implements ProdServiceInt {
//
//    private Map<Integer, Product> productMap;
////    hashmap is NOT PRODUCTION GRADE - bc not threadsafe. just using for returning populate objects
//
//    public ProductServiceImplement() {
//        loadProducts();
////        loadProducts() will set up a bunch of products, and a new hashmap on productMap,
////        and puts  products in it
//    }
//
//    @Override
//    public Product getProduct(Integer id) {
//        return productMap.get(id);
//    }
//
//    @Override
//    public List<Product> listProducts() {
//        return new ArrayList<>(productMap.values());
//    }
//
//    private void loadProducts() {
////        Author bf = new Author("Bryan", "Fitzgerald");
//        Author bf = new Author();
//        bf.setFirstName("Bryan");
//        bf.setLastName("Fitzgerald");
//        bf.setId(1);
//        bf.setImage("https://s3.amazonaws.com/codeup-spring-blog/images/author-bryan-fitzgerald.jpg");
//
//
//        ProductCategory springIntroCat = new ProductCategory();
//        springIntroCat.setId(1);
//        springIntroCat.setCategory("Spring Intro");
//
//        ProductCategory springCoreCat = new ProductCategory();
//        springCoreCat.setId(2);
//        springCoreCat.setCategory("Spring Core");
//
//        ProductCategory springBootCat = new ProductCategory();
//        springBootCat.setId(3);
//        springBootCat.setCategory("Spring Boot");
//
//        ProductCategory thymeleafCat = new ProductCategory();
//        thymeleafCat.setId(4);
//        thymeleafCat.setCategory("Thymeleaf");
//
//        ProductCategory springSecurityCat = new ProductCategory();
//        springSecurityCat.setId(5);
//        springSecurityCat.setCategory("Security!");
//
//        productMap = new HashMap<>();
//
//        Product springIntro = new Product();
//        springIntro.setId(1);
//
//    }
//
//}
//
//
