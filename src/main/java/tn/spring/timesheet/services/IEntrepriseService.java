package tn.spring.timesheet.services;


import tn.spring.timesheet.entities.Entreprise;
import java.util.List;

public interface IEntrepriseService {
    public Entreprise ajouterEntreprise(Entreprise entreprise);
    public List<Entreprise> getAllEntreprise();
    public int getNombreEntreprise();
    public List<String> getAllEntrepriseNames();
    public List<Entreprise> getAllEntrepriseByRaisonSocial(String raisonSocial);
    public Entreprise getEntrepriseById(int entrepriseId);
    public Entreprise editEntrepriseById(Entreprise entreprise,int id);
    public Entreprise editEntrepriseNameById(String name,int id);
    public void deleteEntrepriseById(int entrepriseId);
    public void deleteAllEntreprise();
}
