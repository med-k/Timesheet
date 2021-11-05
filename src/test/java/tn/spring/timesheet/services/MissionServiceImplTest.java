package tn.spring.timesheet.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.spring.timesheet.entity.Mission;
import tn.spring.timesheet.repository.MissionRepository;
import tn.spring.timesheet.service.IMissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.spring.timesheet.service.MissionServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ExtendWith(MockitoExtension.class)

public class MissionServiceImplTest {
    @Mock
    private MissionRepository missionRepository;

    private IMissionService underTest;

    private static final Logger logger = LogManager.getLogger(MissionServiceImplTest.class);

    @BeforeEach
    void setUp(){
        underTest = new MissionServiceImpl(missionRepository);


    }

    @Test
    void AddMission(){
        logger.info("testing addMission");
        logger.debug("adding  entity");
        Mission mission = new Mission("test", "test");
        logger.debug("Mock save method in Missionrepository");
        Mockito.when(missionRepository.save(mission)).thenReturn(mission);
        try {
            logger.debug("testing addMission method");
            Mission addedMission = underTest.AddMission(mission);
            assertThat(addedMission.getName()).isEqualTo(mission.getName());
            logger.info("Out addMission with success");
            assertThat(addedMission.getDescription()).isEqualTo(mission.getDescription());
        } catch (Exception e) {
            logger.error("Error in addMission causedBy" + e.getMessage());
        }
    }
    @Test
    void getAllMission() {
        logger.info("testing getAllMission");
        logger.debug("adding  Mission list for testing");
        List<Mission> listMission = new ArrayList<>();
        logger.debug("adding  first Mission");
        Mission mission1 = new Mission("test","test");
        logger.debug("adding  second mission");
        Mission mission2 = new Mission("test","test");
        logger.debug("adding  third mission");
        Mission mission3 = new Mission("test","test");
        listMission.add(mission1);
        listMission.add(mission2);
        listMission.add(mission3);
        logger.info("Mock findall method in missionrepository");
        Mockito.when(missionRepository.findAll()).thenReturn(listMission);
        try {
            logger.debug("testing getAllMission method");
            List<Mission> listMissionTest = underTest.GetAllMission();
            logger.info("Out getAllMission with success");
            assertThat(listMissionTest).asList().contains(mission1).contains(mission2).contains(mission3).hasSize(3);
        }catch (Exception e){
            logger.error("Error in getAllMission causedBy"+e.getMessage());
        }
    }

    @Test
    void getNombreMission() {
        logger.info("testing getNombreMission");
        logger.info("Mock count Mission method in Missionrepository");
        Mockito.when(missionRepository.countMission()).thenReturn(3);
        try {
            logger.debug("testing getNombreMission method");
            assertThat(underTest.getNombreMission()).isEqualTo(3);
            logger.info("Out getNombreMission with success");
        }catch (Exception e){
            logger.error("Error in getNombreMission causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllMissionNames() {
        logger.info("testing getAllMissionNames");
        logger.debug("creating string name  list for testing");
        List<String> nameList = new ArrayList<>();
        logger.debug("adding  first name");
        nameList.add("test");
        logger.debug("adding  first name");
        nameList.add("test2");
        logger.debug("adding  first name");
        nameList.add("test3");
        logger.info("Mock  getAllMissionNames in missionrepository");
        Mockito.when(missionRepository.getAllNamesOfMission()).thenReturn(nameList);
        try {
            logger.debug("testing getAllMissionNames method");
            assertThat(underTest.getAllMissionNames()).asList().contains("test").contains("test2").contains("test3");
            logger.info("Out getAllMissionNames with success");
        }catch (Exception e){
            logger.error("Error in getAllMissionNames causedBy"+e.getMessage());
        }
    }


    @Test
    void GetMissionById() {
        logger.info("testing GetMissionById");
        logger.debug("creating Mission  entity for testing");
        Mission mission = new Mission("test","test");
        logger.info("Mock findById in missionrepository");
        Mockito.when(missionRepository.findById(1)).thenReturn(java.util.Optional.of(mission));
        try {
            logger.debug("testing GetMissionById method");
            assertThat(underTest.GetMissionById(1).getName()).isEqualTo(mission.getName());
            assertThat(underTest.GetMissionById(1).getDescription()).isEqualTo(mission.getDescription());
            logger.info("Out GetMissionById with success");
        }catch (Exception e){
            logger.error("Error in GetMissionById causedBy"+e.getMessage());
        }

    }


    @Test
    void editMissionDescriptionById() {
        logger.info("testing editMissionDescriptionById");
        int id = 1;
        logger.debug("creating Mission  entity for testing");
        Mission edittedMission =new Mission("test","test2");
        logger.info("Mock findById in MissionRepository");
        Mockito.when(missionRepository.findById(id)).thenReturn(java.util.Optional.of(edittedMission));
        try {
            logger.debug("testing editEntrepriseNameById method");
            Mission updatedMission = underTest.editMissionDescriptionById("test2",1);
            assertThat(updatedMission.getName()).isEqualTo("test");
            logger.info("Out editMissionDescriptionById with success");
        }catch (Exception e){
            logger.error("Error in editMissionDescriptionById causedBy"+e.getMessage());
        }

    }

}
