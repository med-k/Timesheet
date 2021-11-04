package tn.spring.timesheet.Repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.spring.timesheet.entities.Departement;

import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class DepartmenttRepositoryTest {

    private static final Logger logger = LogManager.getLogger(DepartmenttRepositoryTest.class);

    @Autowired
    private DepartmentRepository underTest;

    @AfterEach
    void cleanUp(){
        underTest.deleteAll();
    }

    @Test
    void countDep() {
        logger.info("testing countEntreprise");
        Departement Dep_1 = new Departement("informatique");
        Departement Dep_2 = new Departement("banque");

        logger.debug("adding first Departement entity");
        underTest.save(Dep_1);
        logger.debug("adding second Departement entity");
        underTest.save(Dep_2);

        try {
            logger.debug("testing the method");
            int countDep = underTest.countDep();
            assertThat(countDep).isEqualTo(2);
            logger.info("testing countDepartement on success");
        }catch ( Exception e){
            logger.error("Error in countDepartement causedBy"+e.getMessage());
        }
    }

    @Test
    void DepartmentNames() {
        logger.info("testing DepartmentNames");
        Departement Dep_1 = new Departement("informatique");
        Departement Dep_2 = new Departement("banque");

        logger.debug("adding first Departement entity");
        underTest.save(Dep_1);
        logger.debug("adding second Departement entity");
        underTest.save(Dep_2);

        try {
            logger.debug("testing the method");
            List<String> stringList = underTest.DepartmentNames();
            assertThat(stringList).asList().contains(Dep_1.getName()).contains(Dep_2.getName()).hasSize(2);
            logger.info("testing DepartmentNames on success");
        }catch (Exception e){
            logger.error("Error in DepartmentNames causedBy"+e.getMessage());
        }
    }

    @Test
    void updateDepartmentName(){
        logger.info("test update email");
        Departement Dep_1 = new Departement("informatique");
        logger.info("add Dep_1");
        int id = underTest.save(Dep_1).getId();

        try {
            logger.debug("tester la methode");
            underTest.mettreAjourNameByDepartmentIdJPQL("mecanique",id);
            assertThat(underTest.findById(id).get().getName()).isEqualTo("mecanique");
            logger.info("tester les noms des departments si success");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }
}
