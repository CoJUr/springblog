package com.example.codeup.springblog.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Column(nullable=false, columnDefinition = "VARCHAR(100)")
    private String title;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private long id;

    @Column(nullable=true, columnDefinition = "VARCHAR(255)")
    private String body;

//    file upload functionality


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Post(String title, long id, String body, User user) {
        this.title = title;
        this.id = id;
        this.body = body;
        this.user = user;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title, long id) {
        this.title = title;
        this.id = id;
    }

    public Post(String title, long id, String body) {
        this.title = title;
        this.id = id;
        this.body = body;
    }

    public Post() {}

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}
