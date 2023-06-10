package com.example.sokolovswebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String stsurname, stname, stthirdna, stdateob, studclass, stdocumentnumber;

    public Students(String stsurname, String stname, String stthirdna, String stdateob, String studclass, String stdocumentnumber) {
        this.stsurname = stsurname;
        this.stname = stname;
        this.stthirdna = stthirdna;
        this.stdateob = stdateob;
        this.studclass = studclass;
        this.stdocumentnumber = stdocumentnumber;
    }

    public Students() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStsurname() {
        return stsurname;
    }

    public void setStsurname(String stsurname) {
        this.stsurname = stsurname;
    }

    public String getStname() {
        return stname;
    }

    public void setStname(String stname) {
        this.stname = stname;
    }

    public String getStthirdna() {
        return stthirdna;
    }

    public void setStthirdna(String stthirdna) {
        this.stthirdna = stthirdna;
    }

    public String getStdateob() {
        return stdateob;
    }

    public void setStdateob(String stdateob) {
        this.stdateob = stdateob;
    }

    public String getStudclass() {
        return studclass;
    }

    public void setStudclass(String studclass) {
        this.studclass = studclass;
    }

    public String getStdocumentnumber() {
        return stdocumentnumber;
    }

    public void setStdocumentnumber(String stdocumentnumber) {
        this.stdocumentnumber = stdocumentnumber;
    }
}
