package com.cagmeini.serviciosya.beans.entity;


import javax.persistence.*;

@Entity(name ="City")
@Table (name= "city")
public class CityEntity {

    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn (name="Province_id")
    private ProvinceEntity country;

    public CityEntity() {
    }

    public CityEntity(int id, String name, ProvinceEntity country) {
        this.id = id;
        this.name = name;
        this.country = country;
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

    public ProvinceEntity getCountry() {
        return country;
    }

    public void setCountry(ProvinceEntity country) {
        this.country = country;
    }
}
