package tn.spring.timesheet.Service;
import tn.spring.timesheet.entities.Departement;
import java.util.List;

public interface IDepartmentService {
public int countDep();
public List<String> DepartmentNames();
public void updateDepartmentName(String Name,int id);
public Departement ajouterDepartement(Departement departement);
public List<Departement> getAllDepartement();
public void deleteDepartementById(int id);
}
