package com.cagmeini.serviciosya.beans.entity;

import javax.persistence.*;

@Entity (name = "Occupation")
@Table (name = "occupation")
public class OccupationIdentity {

    // Map the fields (Database tables ) and properties (Java classes)
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column (name = "id", nullable = false, insertable = false, updatable = false)
    private int id;

    @Column (name = "name", length = 48, nullable = false)
    private String name;

    @Column (name = "name", length = 128, nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn (name="parent")
    private OccupationIdentity occupation;


    public OccupationIdentity() {
    }

    public OccupationIdentity(int id, String name, String description, OccupationIdentity occupation) {
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

    public OccupationIdentity getOccupation() {
        return occupation;
    }

    public void setOccupation(OccupationIdentity occupation) {
        this.occupation = occupation;
    }
}
