package tn.spring.timesheet.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.spring.timesheet.entities.Contrat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.time.LocalDate;

@DataJpaTest
public class ContratRepositoryTest {
    private static final Logger logger = LogManager.getLogger(ContratRepositoryTest.class);

    @Autowired
    ContratRepository contratRepository ;

    @Test
    void countCont(){
        logger.info("test Counting Contrat");
        Contrat contrat_1= new Contrat(LocalDate.of(2014, 02, 14),"CDI",2500);
        Contrat contrat_2= new Contrat(LocalDate.of(1996, 12, 01),"CDD",1500);
        logger.info("add contrat_1");
        contratRepository.save(contrat_1);
        logger.info("add contrat_2");
        contratRepository.save(contrat_2);

        try {
            logger.debug("tester la methode");
            int countCont = contratRepository.countcont();
            assertThat(countCont).isEqualTo(2);
            logger.info("tester num de contrat si success");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }

    @Test
    void getContratByType(){
        logger.info("test get Contrats by Type");
        Contrat contrat_1= new Contrat(LocalDate.of(2014, 02, 14),"CDI",2500);
        logger.info("add contrat_1");
        contratRepository.save(contrat_1);


        try {
            logger.debug("tester la methode");
            Contrat cont = contratRepository.getContratByType(contrat_1.getTypeContrat());
            assertThat(cont.getTypeContrat()).isEqualTo(contrat_1.getTypeContrat());

            logger.info("tester si il a un contrat avec type donne en paramettre");
        }catch(Exception e){
            logger.error("error causedBy"+e.getMessage());
        }
    }
}
