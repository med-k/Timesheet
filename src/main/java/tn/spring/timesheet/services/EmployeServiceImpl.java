package tn.spring.timesheet.services;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.repository.EmployeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class EmployeServiceImpl implements IEmployeService{
    private static final Logger logger = LogManager.getLogger(EmployeServiceImpl.class);
    private final EmployeRepository employeRepository;

    @Override
    public Employe addEmploye(Employe employe){
        logger.info("info ajouer employe");
        try{
            logger.debug("debug add employe");
            Employe emp = employeRepository.save(employe);
            logger.info("info employe added successfuly");
            return emp;
        }catch(Exception e){
            logger.error("Error employe non ajouter causedBy"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<Employe> getAllEmploye() {
        logger.info("info get all employe");
        try{
            logger.debug("debug get all employe");
            List<Employe> emps = employeRepository.findAll();
            logger.info("info get all employe success");
            return emps;
        }catch(Exception e){
            logger.error("Error causedBy"+e.getMessage());
            return null;
        }
    }

    @Override
    public int countEmploye() {
        logger.info("info get nombre employe");
        try{
            logger.debug("debug get nombre employe");
            int c = employeRepository.countemp();
            logger.info("info get nombre employe success");
            return c;
        }catch(Exception e){
            logger.error("Error causedBy"+e.getMessage());
            return 0;
        }
    }

    @Override
    public List<String> getNamesOfEmploye() {
        logger.info("info get names employe");
        try{
            logger.debug("debug get names employe");
            List<String> emps = employeRepository.employeNames();
            logger.info("info get names employe success");
            return emps;
        }catch(Exception e){
            logger.error("Error get names causedBy"+e.getMessage());
            return null;
        }
    }

    @Override
    public List<String> getEmailssOfEmploye() {
        logger.info("info get emails employe");
        try{
            logger.debug("debug get emails employe");
            List<String> emails = employeRepository.employeEmail();
            logger.info("info get emails employe success");
            return emails;
        }catch(Exception e){
            logger.error("Error get emails causedBy"+e.getMessage());
            return null;
        }
    }

    @Override
    public Employe getEmployeByEmail(String email) {
        logger.info("info get employ by email");
        try{
            logger.debug("debug get employ by email");
            Employe emp = employeRepository.getEmployeByEmail(email);
            logger.info("info get employ by email success");
            return emp;
        }catch(Exception e){
            logger.error("Error get employ by email causedBy"+e.getMessage());
            return null;
        }
    }

    @Override
    public void mettreAjourEmailByEmployeId(String email, int id) {
        logger.info("info mettre a jour email employe");
        try{
            logger.debug("debug mettre a jour email employe");
            employeRepository.mettreAjourEmailByEmployeIdJPQL(email,id);
            logger.info("info mettre a jour email employe success");
        }catch(Exception e){
            logger.error("Error mettre a jour email employe causedBy"+e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        logger.info("info delete all employe");
        try{
            logger.debug("debug delete all employe");
            employeRepository.deleteAll();
            logger.info("info delete all employe success");
        }catch(Exception e){
            logger.error("Error delete all causedBy"+e.getMessage());
        }
    }

}
