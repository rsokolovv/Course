package com.example.sokolovswebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Grades {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String gfiost, gstudclass, gtitle, grate;

    public Grades(String gfiost, String gstudclass, String gtitle, String grate) {
        this.gfiost = gfiost;
        this.gstudclass = gstudclass;
        this.gtitle = gtitle;
        this.grate = grate;
    }

    public Grades() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGfiost() {
        return gfiost;
    }

    public void setGfiost(String gfiost) {
        this.gfiost = gfiost;
    }

    public String getGstudclass() {
        return gstudclass;
    }

    public void setGstudclass(String gstudclass) {
        this.gstudclass = gstudclass;
    }

    public String getGtitle() {
        return gtitle;
    }

    public void setGtitle(String gtitle) {
        this.gtitle = gtitle;
    }

    public String getGrate() {
        return grate;
    }

    public void setGrate(String grate) {
        this.grate = grate;
    }
}
