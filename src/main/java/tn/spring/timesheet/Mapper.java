package tn.spring.timesheet;

import org.springframework.stereotype.Component;
import tn.spring.timesheet.entities.Contrat;
import tn.spring.timesheet.entities.ContratDTO;

@Component
public class Mapper {

    public ContratDTO toContratDTO(Contrat contrat) {
    ContratDTO contratDTO = new ContratDTO() ;
    contratDTO.setReference(contrat.getReference());
    contratDTO.setDateDebut(contrat.getDateDebut());
    contratDTO.setTypeContrat(contrat.getTypeContrat());
    contratDTO.setSalaire(contrat.getSalaire());
    return contratDTO ;
    }

    public Contrat toContrat( ContratDTO contratDTO) {
        Contrat contrat = new Contrat() ;
        contrat.setReference(contratDTO.getReference());
        contrat.setDateDebut(contratDTO.getDateDebut());
        contrat.setTypeContrat(contratDTO.getTypeContrat());
        contrat.setSalaire(contratDTO.getSalaire());
        return contrat ;
    }
}
