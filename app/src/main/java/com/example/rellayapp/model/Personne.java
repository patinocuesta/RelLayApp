package com.example.rellayapp.model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
//On va serialiser l'objet Personne car on va l'envoyer via un intent vers un autre activité,
// donc il doit etre converti en chaine.
public class Personne implements Serializable {

    private int id;
    private String nom;
    private String prenom;
    private String situPro;
    private String situFa;
    private Boolean enfants;
    private List<String> appart;

    public Personne(int id, String nom, String prenom, String situPro, String situFa, Boolean enfants, List<String> appart) {
        this.id= id;
        this.nom = nom;
        this.prenom = prenom;
        this.situPro = situPro;
        this.situFa = situFa;
        this.enfants = enfants;
        this.appart = appart;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getSituPro() {
        return situPro;
    }

    public void setSituPro(String situPro) {
        this.situPro = situPro;
    }

    public String getSituFa() {
        return situFa;
    }

    public void setSituFa(String situFa) {
        this.situFa = situFa;
    }

    public Boolean getEnfants() {
        return enfants;
    }

    public void setEnfants(Boolean enfants) {
        this.enfants = enfants;
    }

    public List<String> getAppart() {
        return appart;
    }

    public void setAppart(List<String> appart) {
        this.appart = appart;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", situPro='" + situPro + '\'' +
                ", situFa='" + situFa + '\'' +
                ", enfants=" + enfants +
                ", appart=" + appart +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nom, personne.nom) &&
                Objects.equals(prenom, personne.prenom) &&
                Objects.equals(situPro, personne.situPro) &&
                Objects.equals(situFa, personne.situFa) &&
                Objects.equals(enfants, personne.enfants);
    }

}


