//package com.example.codeup.springblog.EagerVsLazy;
//
//import com.example.codeup.springblog.model.demo.Instructor;
//import com.example.codeup.springblog.model.demo.InstructorDetail;
//import org.hibernate.HibernateException;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.springframework.context.annotation.Configuration;
//
//public class EagerLazyDemo {
//
//
//    public static void main(String[] args) {
//
//
//// create session factory
//        SessionFactory sessionFactory = new Configuration()
//                .configure("hibernate.cfg.xml")
//                .addAnnotatedClass(Instructor.class)
//                .addAnnotatedClass(InstructorDetail.class)
//                .buildSessionFactory();
//
////create session
//        Session session = sessionFactory.getCurrentSession();
//
//
//        try{
////            start transcation
//            session.beginTransaction();
//
////            get the instructor from db
//            int theId = 1;
//            Instructor tempInstructor = session.get(Instructor.class, theId);
//
//            System.out.println("tempInstructor: " + tempInstructor);
//
////            print the instructors courses
//            System.out.println("Courses : " + tempInstructor.getCourses());
//
////            commit transaction
//            session.getTransaction().commit();
//
//            System.out.println("Done!");
//
//
//            } catch (Exception e) {
//            System.out.println(e.getMessage());
//            session.getTransaction();
//        }
//
//    }
//
//}
