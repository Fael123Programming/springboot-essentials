package com.rafael.springboot.domain;

public class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setIf(int newId) {
        this.id = newId;
    }
}
