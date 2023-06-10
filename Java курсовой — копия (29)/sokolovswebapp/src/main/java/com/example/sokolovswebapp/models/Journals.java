package com.example.sokolovswebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Journals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String rfiost, rstudclass, rmath, rruslang, rgeom, rphysic, rchem, rtrain;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfiost() {
        return rfiost;
    }

    public void setRfiost(String rfiost) {
        this.rfiost = rfiost;
    }

    public String getRstudclass() {
        return rstudclass;
    }

    public void setRstudclass(String rstudclass) {
        this.rstudclass = rstudclass;
    }

    public String getRmath() {
        return rmath;
    }

    public void setRmath(String rmath) {
        this.rmath = rmath;
    }

    public String getRruslang() {
        return rruslang;
    }

    public void setRruslang(String rruslang) {
        this.rruslang = rruslang;
    }

    public String getRgeom() {
        return rgeom;
    }

    public void setRgeom(String rgeom) {
        this.rgeom = rgeom;
    }

    public String getRphysic() {
        return rphysic;
    }

    public void setRphysic(String rphysic) {
        this.rphysic = rphysic;
    }

    public String getRchem() {
        return rchem;
    }

    public void setRchem(String rchem) {
        this.rchem = rchem;
    }

    public String getRtrain() {
        return rtrain;
    }

    public void setRtrain(String rtrain) {
        this.rtrain = rtrain;
    }

    public Journals() {

    }

    public Journals(String rstudclass, String rfiost, String rmath, String rruslang, String rgeom, String rphysic, String rchem, String rtrain) {
        this.rfiost = rstudclass;
        this.rstudclass = rfiost;
        this.rmath = rmath;
        this.rruslang = rruslang;
        this.rgeom = rgeom;
        this.rphysic = rphysic;
        this.rchem = rchem;
        this.rtrain = rtrain;
    }
}
