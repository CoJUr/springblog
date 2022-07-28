package com.example.codeup.springblog;

public class Post {

    private String title;
    private long id;
    private String body;

    public Post(String title, long id) {
        this.title = title;
        this.id = id;
    }

    public Post(String title, long id, String body) {
        this.title = title;
        this.id = id;
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
}
