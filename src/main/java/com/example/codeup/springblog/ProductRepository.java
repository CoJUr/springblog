package com.example.codeup.springblog;

import com.example.codeup.springblog.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByNameContaining(String str);
}

