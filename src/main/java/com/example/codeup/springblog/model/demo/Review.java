//package com.example.codeup.springblog.model.demo;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//@Table(name = "review")
//public class Review {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private int id;
//
//    @Column(name = "comment")
//    private String comment;
//
//    @Column(name = course_id)
//    private int course_id;
//
//
//
//    public Review(String comment, int course_id) {
//        this.comment = comment;
//        this.course_id = course_id;
//    }
//
//    public Review() {
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getComment() {
//        return comment;
//    }
//
//    public void setComment(String comment) {
//        this.comment = comment;
//    }
//
//    public int getCourse_id() {
//        return course_id;
//    }
//
//    public void setCourse_id(int course_id) {
//        this.course_id = course_id;
//    }
//}
