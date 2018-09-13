package com.cagmeini.serviciosya.beans.entity;

import javax.persistence.*;

@Entity (name = "Country")
@Table (name = "country")
public class CountryEntity {

    //Map the fields(Database tables) and properties (Java classes)
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name= "id", nullable = false,insertable = false, updatable = false)
    private int id;

    @Column (name= "name", length = 48, nullable = false)
    private String name;

    public CountryEntity() {
    }

    public CountryEntity(int id, String name) {
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
