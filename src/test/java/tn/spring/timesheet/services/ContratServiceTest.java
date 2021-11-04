package tn.spring.timesheet.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.spring.timesheet.entities.Contrat;
import tn.spring.timesheet.repository.ContratRepository;
import tn.spring.timesheet.repository.ContratRepositoryTest;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ContratServiceTest {

    private static final Logger logger = LogManager.getLogger(ContratRepositoryTest.class);
    @Mock private ContratRepository contratRepository ;
    private ContratServiceImpl contratService ;

    @BeforeEach
    void setUp() { contratService = new ContratServiceImpl(contratRepository); }

    @Test
    void addContrat() {

        logger.info("test add Contrat");
        logger.debug("adding contrat");
        Contrat contrat_1= new Contrat(LocalDate.of(2014, 02, 14),"CDI",2500);
        logger.debug("add with mock contrat_1");
        Mockito.when(contratRepository.save(contrat_1)).thenReturn(contrat_1) ;
        try {

            logger.debug("testing addContrat method");
            Contrat addedContrat= contratService.addContrat(contrat_1) ;
            verify(contratRepository).save(contrat_1) ;
            assertThat(addedContrat.getTypeContrat()).isEqualTo(contrat_1.getTypeContrat()) ;
            logger.info("Contrat added successfully") ;
        }
        catch (Exception e) {
            logger.error("Error in add caused By"+e.getMessage());
        }


    }

    @Test
    void getAllContrat(){
        logger.info("testing All contrats");
        logger.debug("adding  Contrat list for testing");
        List<Contrat> conts = new ArrayList<>();
        Contrat contrat_1= new Contrat(LocalDate.of(2014, 02, 14),"CDI",2500);
        Contrat contrat_2= new Contrat(LocalDate.of(1996, 12, 01),"CDD",1500);
        conts.add(contrat_1);
        conts.add(contrat_2);
        logger.info("Mock findall method in contratRep");
        Mockito.when(contratRepository.findAll()).thenReturn(conts);

        try{
            logger.debug("testing findall method");
            assertThat(contratService.getAllContrat()).asList().contains(contrat_1,contrat_2);
            logger.info("Out add getAllContrat with success");}

        catch (Exception e){
            logger.error("Error in get all contrat causedBy"+e.getMessage());
        }
    }

    @Test
    void countContrat(){
        logger.info("testing get contrat number");
        logger.info("Mock count contrat method ");
        Mockito.when(contratRepository.countcont()).thenReturn(2);
        try {
            logger.debug("testing getNumberContrat method");
            assertThat(contratService.countContrat()).isEqualTo(2);
            logger.info("Out get number with success");
        }catch (Exception e){
            logger.error("Error in get number causedBy"+e.getMessage());
        }

    }

    @Test
    void getContratByType(){
        logger.info("testing getContratByType");
        logger.debug("creating string type for testing");
        String type= "CDD";
        Contrat contrat_1= new Contrat(LocalDate.of(1996, 12, 01),"CDD",1500);
        logger.debug("creating contrat for testing");
        Mockito.when(contratRepository.getContratByType(type)).thenReturn(contrat_1);
        try {
            logger.debug("testing getContratByType method");
            assertThat(contratService.getByType(type)).isEqualTo(contrat_1);
            logger.info("Out getContratByType with success");
        }catch (Exception e){
            logger.error("Error in getContratByType causedBy"+e.getMessage());
        }

    }

}
