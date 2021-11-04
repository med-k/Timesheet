package tn.spring.timesheet.Service;
import org.apache.logging.log4j.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.logging.log4j.Logger;
import tn.spring.timesheet.entities.Departement;
import tn.spring.timesheet.Repository.DepartmentRepository;
import tn.spring.timesheet.Repository.DepartmenttRepositoryTest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)
 class DepartmentServiceTest {
    private static final Logger logger = LogManager.getLogger(DepartmenttRepositoryTest.class);
    @Mock private DepartmentRepository departmentRepository;
    private DepartmentService departmentService;

    @BeforeEach
    void setUp() {departmentService = new DepartmentService(departmentRepository);}

    @Test
    void ajouterDepartement(){
        logger.info("test add Departement");
        logger.debug("adding  Departement");
        Departement Dep_1= new Departement("informatique");
        logger.debug("add with mock Dep_1");
        Mockito.when(departmentRepository.save(Dep_1)).thenReturn(Dep_1);
        try{
            logger.debug("testing addDepartement method");
            Departement addedDepartement= departmentService.ajouterDepartement(Dep_1);
            verify(departmentRepository).save(Dep_1);
            assertThat(addedDepartement.getName()).isEqualTo(Dep_1.getName());
            logger.info("Out add Departement with success");}

        catch (Exception e){
            logger.error(e.getMessage());
        }
    }

    @Test
    void getAllDepartement(){
        logger.info("testing getAllDepartement");
        logger.debug("adding  Departement list for testing");
        List<Departement> dep = new ArrayList<>();
        Departement Dep_1= new Departement("informatique");
        Departement Dep_2= new Departement("mecanique");
        dep.add(Dep_1);
        dep.add(Dep_2);
        logger.info("Mock findall method in DepartementRepository");
        Mockito.when(departmentRepository.findAll()).thenReturn(dep);

        try{
            logger.debug("testing findall method");
            assertThat(departmentService.getAllDepartement()).asList().contains(Dep_1,Dep_2);
            logger.info("Out add getallDepartement with success");}

        catch (Exception e){
            logger.error(e.getMessage());
        }


    }
    @Test
    void countDep(){
        logger.info("testing getNombreDepartment");
        logger.info("Mock count department method ");
        Mockito.when(departmentRepository.countDep()).thenReturn(2);
        try {
            logger.debug("testing getNombreDepartment method");
            assertThat(departmentService.countDep()).isEqualTo(2);
            logger.info("Out getNombreDepartment with success");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    @Test
    void getDepName(){
        logger.info("testing getAllEmployNames");
        logger.debug("creating string name list for testing");
        List<String> names= new ArrayList<>();
        names.add("hama");
        names.add("ala");
        logger.info("Mock  getAllNamesOfEmploy in employrepository");
        Mockito.when(departmentRepository.DepartmentNames()).thenReturn(names);
        try {
            logger.debug("testing getAllNamesOfEmploy method");
            assertThat(departmentService.DepartmentNames()).asList().contains("hama").contains("ala").hasSize(2);
            logger.info("Out getAllNamesOfEmploy with success");
        }catch (Exception e){
            logger.error(e.getMessage());
        }
    }


}
