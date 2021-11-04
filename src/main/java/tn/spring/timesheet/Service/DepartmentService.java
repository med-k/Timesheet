package tn.spring.timesheet.Service;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.spring.timesheet.entities.Departement;
import tn.spring.timesheet.Repository.DepartmentRepository;

import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class DepartmentService implements IDepartmentService {

    private static final Logger logger = LogManager.getLogger(DepartmentService.class);

    private final DepartmentRepository departmentRepository;
    @Override
    public int countDep() {
        logger.info("info get nombre Department");
        try{
            logger.debug("debug get nombre Department");
            int d = departmentRepository.countDep();
            logger.info("info get nombre Department success");
            return d;
        }catch(Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public  List<String> DepartmentNames() {
        logger.info("info get names Department");
        try{
            logger.debug("debug get names Department");
            List<String> Deps = departmentRepository.DepartmentNames();
            logger.info("info get names Department success");
            return Deps;
        }catch(Exception e){
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void updateDepartmentName(String Name, int id) {
        logger.info("info mettre a jour email employe");
        try{
            logger.debug("debug mettre a jour email employe");
            departmentRepository.mettreAjourNameByDepartmentIdJPQL(Name,id);
            logger.info("info mettre a jour email employe success");
        }catch(Exception e){
            logger.error(e.getMessage());
        }
    }

    @Override
    public Departement ajouterDepartement(Departement departement) {
        logger.info("In ajouterDepartement");

        try {
            logger.debug("adding  entity");
            Departement addedDepartement = departmentRepository.save(departement);
            logger.info("Out ajouterDepartement with success");
            return addedDepartement;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Departement> getAllDepartement() {
        logger.info("In getAllDepartement");

        try {
            logger.debug("getting all entreprise");
            List<Departement> listDepartement = departmentRepository.findAll();
            logger.info("Out getAllDepartement with success");
            return listDepartement;
        }catch (Exception e){
            logger.error(e.getMessage());
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteDepartementById(int id) {
        logger.info("In editDepartementNameById");

        try {
            logger.debug("deleting Departement by id");
            departmentRepository.deleteById(id);
            logger.info("Out editDepartementNameById with success");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }
}
