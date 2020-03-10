package com.example.rellayapp.model;

import java.io.Serializable;
import java.util.Objects;
//On va serialiser l'objet Personne car on va l'envoyer via un intent vers un autre activité,
// donc il doit etre converti en chaine.
public class Personne implements Serializable {

    private String nom;
    private String prenom;
    private String langue;

    public Personne(String nom, String prenom, String langue) {
        this.nom = nom;
        this.prenom = prenom;
        this.langue = langue;
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

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    @Override
    public String toString() {
        return   "User: "+ prenom + " " + nom +"\nLangue: " + langue ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) &&
                Objects.equals(prenom, personne.prenom) &&
                Objects.equals(langue, personne.langue);
    }

}
