package com.example.codeup.springblog;

import com.example.codeup.springblog.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringblogApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner run(ProductRepository productDao) {
//        return args -> {
//            productDao.findProductByNameContaining("Topi");
//        };
//    }

//
//    @Bean
//    public CommandLineRunner run(EmployeeRepository repository) {
//        return (args -> {
//            insertJavaAdvocates(repository);
//            System.out.println(repository.findAll());
//        });
//    }
//
//    public void insertJavaAdvocates(EmployeeRepository repository) {
//        repository.save(new Employee("Mister", "Advocate"));
//        repository.save(new Employee("Missy", "Advocate"));
//        repository.save(new Employee("Senor", "Advocate"));
//        repository.save(new Employee("Senorita", "Proponente"));
//        repository.save(new Employee("Erb", "Jean"));
//    }

}
