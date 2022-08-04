package com.example.codeup.springblog.repositories;

import com.example.codeup.springblog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByNameContaining(String str);

//    derived queries - can create varied of methods which Hibernate will use to perform the query
    List<Product> getProductsByIdAfter(long id);
    List<Product> getProductByNameEndsWithIgnoreCase(String str);


//    custom queries. JPQL to define more specific queries
    @Query("SELECT p.name from Product p ORDER BY p.name DESC")
    List<String> getProductNames();


//    native queries - mySQL syntax based queries
    @Query(nativeQuery = true, value = "SELECT name FROM products p ORDER BY name DESC")
    List<String> getProductNamesNative();
}

