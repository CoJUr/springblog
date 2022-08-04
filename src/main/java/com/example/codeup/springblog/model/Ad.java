package com.example.codeup.springblog.model;

import javax.persistence.*;

@Entity
@Table(name = "ads")
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "title", nullable = false)
    private String title;

    @Column(columnDefinition = "VARCHAR(150)")
    private String description;

    @Column(columnDefinition = "VARCHAR(150)")
    private String path;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Ad() {
    }

    public Ad(Long id, String title, String description, String path, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.path = path;
        this.user = user;
    }

    public Ad(Long id, String title, String description, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}