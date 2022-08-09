package com.example.codeup.springblog.model.demo;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

//    cascade all to delete reviews when course is deleted
    @OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//    join is for a unidirectional oneToMany relationship, so foreign key is on the other side. if it were bidirectional, the FK would be in the join table
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    public Course() {}

    public Course(String title, Instructor instructor) {
        this.title = title;
        this.instructor = instructor;
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", instructor=" + instructor +
                '}';
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

//    convenience method to add reviews to list
    public void addReview(Review tempReview) {

        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(tempReview);
    }
}
