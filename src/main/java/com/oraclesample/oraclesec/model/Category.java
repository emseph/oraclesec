package com.oraclesample.oraclesec.model;

import javax.persistence.*;

@Entity
public class Category {

    @Id
    @SequenceGenerator(name = "CATEGORY_SEQ",
     sequenceName = "CATEGORY_SEQ",
      initialValue = 1,
       allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_SEQ")
    @Column(name = "category_id")
    private int id;

    private String name;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
