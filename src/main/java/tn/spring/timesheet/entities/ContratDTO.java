package tn.spring.timesheet.entities;

import javax.persistence.*;
import java.time.LocalDate;

public class ContratDTO {
    private static final long serialVersionUID = -1396669830860400871L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int reference;
    private LocalDate dateDebut;

    private String typeContrat;

    private float salaire;

    public ContratDTO() {
        super();
    }
    public ContratDTO(LocalDate dateDebut, String typeContrat, float salaire) {
        this.dateDebut = dateDebut;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
    }

    public int getReference() {
        return reference;
    }

    public void setReference(int reference) {
        this.reference = reference;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }
}
