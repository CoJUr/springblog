package com.example.codeup.springblog.CreateDemo;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.Product;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.model.demo.Instructor;
import com.example.codeup.springblog.model.demo.InstructorDetail;
import com.mysql.cj.xdevapi.SessionFactory;
import org.springframework.context.annotation.Configuration;
import org.hibernate.Session;
public class CreateDemo {

    public static void main(String[] args) {

//        create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
    }
}
