package com.capgemini.serviciosya.beans.entity;


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
    private ProvinceEntity province;

    public CityEntity() {
    }

    public CityEntity(int id, String name, ProvinceEntity province) {
        this.id = id;
        this.name = name;
        this.province = province;
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

    public ProvinceEntity getProvince() {
        return province;
    }

    public void setProvince(ProvinceEntity province) {
        this.province = province;
    }
}
