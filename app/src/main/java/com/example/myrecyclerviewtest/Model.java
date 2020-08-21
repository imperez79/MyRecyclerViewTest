package com.example.myrecyclerviewtest;

import java.io.Serializable;

public class Model implements Serializable {
    private  boolean state;
    private int id;
    private String name ;
    private String surName;

    public Model(){
        this.state = false ;
    }

    public Model(int id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.state = false;
    }

    public Model( String name, String surName) {
        this.name = name;
        this.surName = surName;
        this.state = false;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
