package com.example.codeup.springblog.model.demo;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "first_name", nullable = false) private String firstName;

    @Column(name = "last_name", nullable = false) private String lastName;

    @Column(name = "email") private String email;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.REMOVE})
//    joining on own FK column
    @JoinColumn(name = "instructor_detail_id")
    private InstructorDetail instructorDetail;
//map to instructor_detail table



    public Instructor() {
    }


    public Instructor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public static void main(String[] args) {
//        Instructor tempInstructor = new Instructor( "John", "Doe", "john@doe.com");
//        InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.subscribepls/youtube", "selling out");

//        associate the objs
//        tempInstructor.setInstructorDetail(tempInstructorDetail);
//
////        start transaction
//
//        session.beginTransaction();
//
//        session.save(tempInstructor);
//
////        persist the objs
//        session.getTransaction().commit();
//
//    }




    private void setInstructorDetail(InstructorDetail tempInstructorDetail) {
        this.instructorDetail = tempInstructorDetail;
    }


    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
