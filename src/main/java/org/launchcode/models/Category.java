package org.launchcode.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    //id field + annotations
    @Id
    @GeneratedValue
    private int id;

    //name field + annotations
    @NotNull
    @Size(min=3, max=15)
    private String name;

    //ArrayList to hold cheeses list
    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Cheese> cheeses = new ArrayList<>();

    //default no argument constructor
    public Category () {
    }

    //constructor that takes a name
    public Category (String name) {
        this.name = name;
    }

    //getter for Id
    public int getId() {
        return id;
    }

    //getter and setter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
