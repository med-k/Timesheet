package tn.spring.timesheet;

import org.springframework.stereotype.Component;
import tn.spring.timesheet.entities.Departement;
import tn.spring.timesheet.entities.DepartementDTO;

@Component
public class Mapper {
    public DepartementDTO toDepartementDto(Departement departement){
        DepartementDTO departmentDTO = new DepartementDTO();
        departmentDTO.setName(departement.getName());
        departmentDTO.setId(departement.getId());

        return departmentDTO;
    }

    public Departement toDepartement(DepartementDTO departementDTO){
        Departement departement = new Departement();
        departement.setId(departementDTO.getId());
        departement.setName(departementDTO.getName());
        return departement;
    }
}
