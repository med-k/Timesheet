package tn.spring.timesheet.services;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.entities.Role;
import tn.spring.timesheet.repository.EmployeRepository;
import org.apache.logging.log4j.Logger;
import tn.spring.timesheet.repository.EmployeRepositoryTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@ExtendWith(MockitoExtension.class)
public class EmployeServiceTest {
    private static final Logger logger = LogManager.getLogger(EmployeRepositoryTest.class);
    @Mock private EmployeRepository employeRepository;
    private EmployeServiceImpl employeService;

    @BeforeEach
    void setUp() {employeService = new EmployeServiceImpl(employeRepository);}

    @Test
    void addEmploye(){
        logger.info("test add Employe");
        logger.debug("adding  employe");
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        logger.debug("add with mock employe_1");
        Mockito.when(employeRepository.save(employe_1)).thenReturn(employe_1);
        try{
            logger.debug("testing addEntreprise method");
        Employe addedEmploye= employeService.addEmploye(employe_1);
        verify(employeRepository).save(employe_1);
        assertThat(addedEmploye.getEmail()).isEqualTo(employe_1.getEmail());
            logger.info("Out add employ with success");}

        catch (Exception e){
            logger.error("Error in add employ causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllEmploye(){
        logger.info("testing getAllEmploy");
        logger.debug("adding  Employe list for testing");
    List<Employe> emps = new ArrayList<>();
    Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
    Employe employe_2= new Employe("jean","kaka","jean@gmail.com",true, Role.INGENIEUR);
    emps.add(employe_1);
    emps.add(employe_2);
    logger.info("Mock findall method in employRepository");
    Mockito.when(employeRepository.findAll()).thenReturn(emps);

        try{
            logger.debug("testing findall method");
            assertThat(employeService.getAllEmploye()).asList().contains(employe_1,employe_2);
            logger.info("Out add getallemploy with success");}

        catch (Exception e){
            logger.error("Error in get all employ causedBy"+e.getMessage());
        }
    }
    @Test
    void countEmploye(){
        logger.info("testing getNombreEmploy");
        logger.info("Mock count employe method ");
    Mockito.when(employeRepository.countemp()).thenReturn(2);
        try {
            logger.debug("testing getNombreEmploy method");
            assertThat(employeService.countEmploye()).isEqualTo(2);
            logger.info("Out getNombreEmploy with success");
        }catch (Exception e){
            logger.error("Error in getNombreEmploy causedBy"+e.getMessage());
        }

    }

    @Test
    void getNamesOfEmploye(){
        logger.info("testing getAllEmployNames");
        logger.debug("creating string name list for testing");
        List<String> names= new ArrayList<>();
        names.add("hama");
        names.add("ala");
        logger.info("Mock  getAllNamesOfEmploy in employrepository");
        Mockito.when(employeRepository.employeNames()).thenReturn(names);
        try {
            logger.debug("testing getAllNamesOfEmploy method");
            assertThat(employeService.getNamesOfEmploye()).asList().contains("hama").contains("ala").hasSize(2);
            logger.info("Out getAllNamesOfEmploy with success");
        }catch (Exception e){
            logger.error("Error in getAllNamesOfEmploy causedBy"+e.getMessage());
        }
    }
    @Test
    void getEmailssOfEmploye(){
        logger.info("testing getAllEmployemail");
        logger.debug("creating string email list for testing");
        List<String> emails= new ArrayList<>();
        emails.add("hama@gmail.com");
        emails.add("ala@esprit.tn");
        logger.info("Mock  getAllEmailOfEmploy in employrepository");
        Mockito.when(employeRepository.employeEmail()).thenReturn(emails);
        try {
            logger.debug("testing getAllNamesOfEmploy method");
            assertThat(employeService.getEmailssOfEmploye()).asList().contains("hama@gmail.com").contains("ala@esprit.tn").hasSize(2);
            logger.info("Out getAllNamesOfEmploy with success");
        }catch (Exception e){
            logger.error("Error in getAllNamesOfEmploy causedBy"+e.getMessage());
        }
    }
    @Test
    void getEmployeByEmail(){
        logger.info("testing getEmployByemail");
        logger.debug("creating string email for testing");
        String email= "papi@gmail.com";
        Employe employe_1= new Employe("papi","riahi","papi@gmail.com",true, Role.INGENIEUR);
        logger.debug("creating employfor testing");
        Mockito.when(employeRepository.getEmployeByEmail(email)).thenReturn(employe_1);
        try {
            logger.debug("testing getEmployeByEmail method");
            assertThat(employeService.getEmployeByEmail(email)).isEqualTo(employe_1);
            logger.info("Out getEmployeByEmail with success");
        }catch (Exception e){
            logger.error("Error in getEmployeByEmail causedBy"+e.getMessage());
        }

    }
}
