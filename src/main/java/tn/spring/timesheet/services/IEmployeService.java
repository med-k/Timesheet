package tn.spring.timesheet.services;

import tn.spring.timesheet.entities.Employe;

import java.util.List;

public interface IEmployeService {
    public Employe addEmploye(Employe employe);
    public List<Employe> getAllEmploye();
    public int countEmploye();
    public List<String> getNamesOfEmploye();
    public List<String> getEmailssOfEmploye();
    public Employe getEmployeByEmail(String email);
    public void mettreAjourEmailByEmployeId(String email,int id);
    public void deleteAll();
}
