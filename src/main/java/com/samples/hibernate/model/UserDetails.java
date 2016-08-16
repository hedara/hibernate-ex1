package com.samples.hibernate.model;

import javax.persistence.*;

/**
 * Created by edara on 8/9/16.
 */
@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
    @Id @GeneratedValue
    @Column(name="ID")
    private int id;
    @Column(name="NAME")
    private String name;
    @Column(name="DESCRIPTION")
    @Lob
    private String description;

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
}
