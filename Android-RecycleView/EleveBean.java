package com.example.recycleviewmodule;

/**
 * Created by DEV on 15/09/2016.
 */
public class EleveBean {

    public String nom;
    public String prenom;

    public EleveBean(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}