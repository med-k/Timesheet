package tn.spring.timesheet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;


public class EmployeDTO {
    private static final long serialVersionUID = -1396669830860400871L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String prenom;

    private String nom;

    //@Column(unique=true)
    private String email;

    private boolean isActif;



    public EmployeDTO() {
        super();
    }

    public EmployeDTO(String nom, String prenom, String email, boolean isActif) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.isActif = isActif;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActif() {
        return isActif;
    }

    public void setActif(boolean isActif) {
        this.isActif = isActif;
    }

}
