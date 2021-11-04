package tn.spring.timesheet.services;

import tn.spring.timesheet.entities.Contrat;

import java.util.List;

public interface IContratService {

    public Contrat addContrat(Contrat contrat) ;
    public List<Contrat> getAllContrat();
    public int countContrat() ;
   public Contrat getByType(String type) ;
}
