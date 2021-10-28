package tn.spring.timesheet.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.spring.timesheet.entities.Entreprise;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@DataJpaTest
class EntrepriseRepositoryTest {

    private static final Logger logger = LogManager.getLogger(EntrepriseRepositoryTest.class);


    @Autowired
    private EntrepriseRepository underTest;

    @AfterEach
    void cleanUp(){
        underTest.deleteAll();
    }

    @Test
    void countEntreprise() {
        logger.info("testing countEntreprise");
        Entreprise entreprise_1 = new Entreprise("tictactrip","informatique");
        Entreprise entreprise_2 = new Entreprise("societe generale","banque");

        logger.debug("adding first Entreprise entity");
        underTest.save(entreprise_1);
        logger.debug("adding second Entreprise entity");
        underTest.save(entreprise_2);

        try {
            logger.debug("testing the method");
            int countEntreprise = underTest.countEntreprise();
            assertThat(countEntreprise).isEqualTo(2);
            logger.info("testing countEntreprise on success");
        }catch ( Exception e){
            logger.error("Error in countEntreprise causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllNamesOfEntreprise() {
        logger.info("testing getAllNamesOfEntreprise");
        Entreprise entreprise_1 = new Entreprise("tictactrip","informatique");
        Entreprise entreprise_2 = new Entreprise("societe generale","banque");

        logger.debug("adding first Entreprise entity");
        underTest.save(entreprise_1);
        logger.debug("adding second Entreprise entity");
        underTest.save(entreprise_2);

        try {
            logger.debug("testing the method");
            List<String> stringList = underTest.getAllNamesOfEntreprise();
            assertThat(stringList).asList().contains(entreprise_1.getName()).contains(entreprise_2.getName()).hasSize(2);
            logger.info("testing getAllNamesOfEntreprise on success");
        }catch (Exception e){
            logger.error("Error in getAllNamesOfEntreprise causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllEntrepriseByRaisonSocial() {
        logger.info("testing getAllEntrepriseByRaisonSocial");
        Entreprise entreprise_1 = new Entreprise("tictactrip","informatique");
        Entreprise entreprise_2 = new Entreprise("societe generale","banque");

        logger.debug("adding first Entreprise entity");
        underTest.save(entreprise_1);
        logger.debug("adding second Entreprise entity");
        underTest.save(entreprise_2);

        try {
            logger.debug("testing the method");
            List<Entreprise> entrepriseList = underTest.getAllEntrepriseByRaisonSocial("informatique");
            assertThat(entrepriseList).asList().contains(entreprise_1).hasSize(1);
            logger.info("testing getAllEntrepriseByRaisonSocial on success");
        }catch (Exception e){
            logger.error("Error in getAllEntrepriseByRaisonSocial causedBy"+e.getMessage());
        }
    }

    @Test
    void editEntrepriseByName(){
        logger.info("testing editEntrepriseByName");
        Entreprise entreprise_1 = new Entreprise("tictactrip","informatique");

        logger.debug("adding  Entreprise entity");
        int idEntreprise = underTest.save(entreprise_1).getId();

        try {
            logger.debug("testing the method");
            underTest.editEntrepriseName("test",idEntreprise);

            Entreprise updatedEntreprise = underTest.findById(idEntreprise).get();

            assertThat(updatedEntreprise.getRaisonSocial()).isNotNull().isEqualTo("informatique");
            assertThat(updatedEntreprise.getName()).isNotNull().isEqualTo("test");
            logger.info("testing editEntrepriseByName on success");
        }catch (Exception e){
            logger.error("Error in editEntrepriseByName causedBy"+e.getMessage());
        }
    }

}