package com.example.codeup.springblog;

import java.util.List;

public class Item {

    private int id;
    private String name;

    private List<Detail> details;

    public Item(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Item(int id, String name, List<Detail> details) {
        this.id = id;
        this.name = name;
        this.details = details;
    }

    public List<Detail> getDetails() {
        return details;
    }

    public void setDetails(List<Detail> details) {
        this.details = details;
    }
}
