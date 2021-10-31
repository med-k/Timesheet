package tn.spring.timesheet;

import org.springframework.stereotype.Component;
import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.entities.EmployeDTO;

@Component
public class Mapper {
    public EmployeDTO toEmployeDto(Employe employe){
        EmployeDTO employeDTO = new EmployeDTO();
        employeDTO.setNom(employe.getNom());
        employeDTO.setEmail(employe.getEmail());
        employeDTO.setId(employe.getId());
        employeDTO.setActif(employe.isActif());
        employeDTO.setPrenom(employe.getPrenom());
        return employeDTO;
    }

    public Employe toEmploye(EmployeDTO employeDTO){
        Employe employe = new Employe();
        employe.setId(employeDTO.getId());
        employe.setNom(employeDTO.getNom());
        employe.setEmail(employeDTO.getEmail());
        employe.setActif(employeDTO.isActif());
        employe.setPrenom(employeDTO.getPrenom());
        return employe;
    }

}