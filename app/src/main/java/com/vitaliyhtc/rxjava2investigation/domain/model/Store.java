package com.vitaliyhtc.rxjava2investigation.domain.model;
// TODO: 26/07/17 these models should be in presentation layer
public class Store {
    private int id;
    private String name;

    public Store(int id, String name) {
        this.id = id;
        this.name = name;
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
}
