package com.example.codeup.springblog.services;


import com.example.codeup.springblog.model.sfg.Product;
import com.example.codeup.springblog.model.sfg.*;

import java.util.List;

public interface ProdServiceInt {

    Product getProduct(Integer id);

    List<Product> listProducts();
//    returns list of all products
}
