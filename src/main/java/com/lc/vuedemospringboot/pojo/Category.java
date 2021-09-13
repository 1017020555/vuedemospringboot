package com.lc.vuedemospringboot.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "category")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Category {

    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Id
    int id;

    @Column(name = "name")
    String name;

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

