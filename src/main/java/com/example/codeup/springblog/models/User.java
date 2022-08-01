package com.example.codeup.springblog.models;

import com.example.codeup.springblog.Post;
import com.example.codeup.springblog.models.Ad;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, columnDefinition = "VARCHAR(150)")
    private String username;

    @Column(columnDefinition = "VARCHAR(150)")
    private String email;

    @Column(columnDefinition = "VARCHAR(150)")
    private String password;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Post> post = new ArrayList<>();

    public User(long id, String username, String email, String password, List<Post> post) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.post = post;
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;

    }

    public List<Post> getAd() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
