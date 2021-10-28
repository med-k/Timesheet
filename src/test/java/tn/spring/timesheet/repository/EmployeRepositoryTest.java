package tn.spring.timesheet.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.entities.Role;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeRepositoryTest {
    private static final Logger logger = LogManager.getLogger(EmployeRepositoryTest.class);

    @Autowired
    EmployeRepository employeRepository;

    @Test
    void countEmploye(){
        logger.info("test Counting Employe");
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        Employe employe_2= new Employe("ala","bacha","ala@gmail.fr",true, Role.TECHNICIEN);
        logger.info("add employe_1");
        employeRepository.save(employe_1);
        logger.info("add employe_2");
        employeRepository.save(employe_2);

        try {
            logger.debug("tester la methode");
            int countEmploye = employeRepository.countemp();
            assertThat(countEmploye).isEqualTo(2);
            logger.info("tester compte employer si success");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }
    @Test
    void getNameOfEmploye(){
        logger.info("test get Employe by name");
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        Employe employe_2= new Employe("ala","bacha","ala@gmail.fr",true, Role.TECHNICIEN);
        logger.info("add employe_1");
        employeRepository.save(employe_1);
        logger.info("add employe_2");
        employeRepository.save(employe_2);

        try {
            logger.debug("tester la methode");
            List<String> employeName = employeRepository.employeNames();
            assertThat(employeName).asList().contains(employe_1.getNom()).contains(employe_2.getNom()).hasSize(2);
            logger.info("tester les nom des employes si success");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }
    @Test
    void getEmailOfEmploye(){
        logger.info("test get emails of employe");
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        Employe employe_2= new Employe("ala","bacha","ala@gmail.fr",true, Role.TECHNICIEN);
        logger.info("add employe_1");
        employeRepository.save(employe_1);
        logger.info("add employe_2");
        employeRepository.save(employe_2);

        try {
            logger.debug("tester la methode");
            List<String> employeName = employeRepository.employeEmail();
            assertThat(employeName).asList().contains(employe_1.getEmail()).contains(employe_2.getEmail()).hasSize(2);
            logger.info("tester les email des employes si success");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }
    @Test
    void getEmployeByEmail(){
        logger.info("test get Employe by email");
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        logger.info("add employe_1");
        employeRepository.save(employe_1);


        try {
            logger.debug("tester la methode");
            Employe emp = employeRepository.getEmployeByEmail(employe_1.getEmail());
            assertThat(emp.getNom()).isEqualTo(employe_1.getNom());
            assertThat(emp.isActif()).isEqualTo(employe_1.isActif());
            logger.info("tester si il a employe avec email donne en paramettre");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }
    @Test
    void updateEmployEmail(){
        logger.info("test update email");
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        logger.info("add employe_1");
        int id = employeRepository.save(employe_1).getId();

        try {
            logger.debug("tester la methode");
            employeRepository.mettreAjourEmailByEmployeIdJPQL("test@gmail.com",id );
            assertThat(employeRepository.findById(id).get().getEmail()).isEqualTo("test@gmail.com");
            logger.info("tester les email des employes si success");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }

}
