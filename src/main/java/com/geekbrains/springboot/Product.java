package com.geekbrains.springboot;

public class Product {
    private long id;
    private String title;
    private long coast;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getCoast() {
        return coast;
    }

    public void setCoast(long coast) {
        this.coast = coast;
    }
}
