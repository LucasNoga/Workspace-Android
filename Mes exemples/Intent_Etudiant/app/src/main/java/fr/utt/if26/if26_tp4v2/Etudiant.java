package fr.utt.if26.if26_tp4v2;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Etudiant implements Serializable {

    private String nom;
    private String prenom;
    private int age;
    private String langage;
    private String sexe;


    public Etudiant(String nom, String prenom, int age, String langage, String sexe) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.langage = langage;
        this.sexe = sexe;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLangage() {
        return langage;
    }

    public void setLangage(String langage) {
        this.langage = langage;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
}
