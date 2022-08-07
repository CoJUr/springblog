//package com.example.codeup.springblog.CreateDemo;
//
//import com.example.codeup.springblog.model.Post;
//import com.example.codeup.springblog.model.Product;
//import com.example.codeup.springblog.model.User;
//import com.example.codeup.springblog.model.demo.Instructor;
//import com.example.codeup.springblog.model.demo.InstructorDetail;
//import com.mysql.cj.xdevapi.SessionFactory;
//import org.springframework.context.annotation.Configuration;
//import org.hibernate.Session;
//
//
//public class CreateDemo {
//
//
//
//    public static void main(String[] args) {
//
//        Instructor tempInstructor = new Instructor("John", "Doe", "did@dod.com");
//        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.subscribepls/youtube", "selling out");
//
////        associate the object in memory
//        tempInstructor.setInstructorDetail(tempInstructorDetail);
//
////        save the tempInstructor to the database... which also saves the details object due to CascadeType.ALL
//        session.save(tempInstructor);
//
////        create session factory
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Instructor.class)
//                .addAnnotatedClass(InstructorDetail.class)
//                .buildSessionFactory();
//    }
//
//}
