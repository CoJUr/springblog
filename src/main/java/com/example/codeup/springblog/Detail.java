package com.example.codeup.springblog;

public class Detail {

    private int id;
    private String description;

    public Detail(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public Detail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
