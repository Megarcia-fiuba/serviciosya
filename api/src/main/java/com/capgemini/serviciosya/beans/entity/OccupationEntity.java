package com.capgemini.serviciosya.beans.entity;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity (name = "Occupation")
@Table (name = "occupation")
public class OccupationEntity {

    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @Column (name = "description", length = 128, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn (name="parent")
    private OccupationEntity occupation;

    @ManyToMany(mappedBy = "occupations")
    private Set<ProviderEntity> Providers = new HashSet<>();


    public OccupationEntity() {
    }

    public OccupationEntity(int id, String name, String description, OccupationEntity occupation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.occupation = occupation;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OccupationEntity getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationEntity occupation) {
        this.occupation = occupation;
    }
}
