package com.example.sokolovswebapp.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Events {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titles, anonse, full_texte, publicatione;

    public Events(String titles, String anonse, String full_texte, String publicatione) {
        this.titles = titles;
        this.anonse = anonse;
        this.full_texte = full_texte;
        this.publicatione = publicatione;
    }

    public Events() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getAnonse() {
        return anonse;
    }

    public void setAnonse(String anonse) {
        this.anonse = anonse;
    }

    public String getFull_texte() {
        return full_texte;
    }

    public void setFull_texte(String full_texte) {
        this.full_texte = full_texte;
    }

    public String getPublicatione() {
        return publicatione;
    }

    public void setPublicatione(String publicatione) {
        this.publicatione = publicatione;
    }
}
