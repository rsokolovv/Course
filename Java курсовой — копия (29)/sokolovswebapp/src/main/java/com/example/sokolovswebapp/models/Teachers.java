package com.example.sokolovswebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Teachers {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fioteach, teachbirth, teachscience, teachnumb;

    public Teachers(String fioteach, String teachbirth, String teachscience, String teachnumb) {
        this.fioteach = fioteach;
        this.teachbirth = teachbirth;
        this.teachscience = teachscience;
        this.teachnumb = teachnumb;
    }

    public Teachers() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFioteach() {
        return fioteach;
    }

    public void setFioteach(String fioteach) {
        this.fioteach = fioteach;
    }

    public String getTeachbirth() {
        return teachbirth;
    }

    public void setTeachbirth(String teachbirth) {
        this.teachbirth = teachbirth;
    }

    public String getTeachscience() {
        return teachscience;
    }

    public void setTeachscience(String teachscience) {
        this.teachscience = teachscience;
    }

    public String getTeachnumb() {
        return teachnumb;
    }

    public void setTeachnumb(String teachnumb) {
        this.teachnumb = teachnumb;
    }
}
