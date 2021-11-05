package tn.spring.timesheet.repository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import tn.spring.timesheet.entity.Mission;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@DataJpaTest
public class MissionRepositoryTest {
    private static final Logger logger = LogManager.getLogger(MissionRepositoryTest.class);

    @Autowired
    MissionRepository missionRepository;

    @AfterEach
    void cleanUp(){
        missionRepository.deleteAll();
    }

    @Test
    void countMissionOnSucces(){
        logger.info("testing countEntreprise");
        Mission mission1 = new Mission("test1","test1");
        Mission mission2 = new Mission("test2","test2");

        logger.debug("adding first Mission entity");
        missionRepository.save(mission1);
        logger.debug("adding second Mission entity");
        missionRepository.save(mission2);

        try {
            logger.debug("testing the method");
            int countMission = missionRepository.countMission();
            assertThat(countMission).isEqualTo(2);
            logger.info("testing countMission on success");
        }catch ( Exception e){
            logger.error("Error in countMission causedBy"+e.getMessage());
        }
    }

    @Test
    void getAllNamesOfMission() {
        logger.info("testing getAllNamesOfEntreprise");
        Mission mission1 = new Mission("test1","test1");
        Mission mission2 = new Mission("test2","test2");

        logger.debug("adding first Mission entity");
        missionRepository.save(mission1);
        logger.debug("adding second Mission entity");
        missionRepository.save(mission2);

        try {
            logger.debug("testing the method");
            List<String> stringList = missionRepository.getAllNamesOfMission();
            assertThat(stringList).asList().contains(mission1.getName()).contains(mission2.getName()).hasSize(2);
            logger.info("testing getAllNamesOfMission on success");
        }catch (Exception e){
            logger.error("Error in getAllNamesOfMission causedBy"+e.getMessage());
        }
    }

    @Test
    void editMissiondescription(){
        logger.info("testing editMissionDescription");
        Mission mission1 = new Mission("tooly","developper un site web");

        logger.debug("adding  Mission entity");
        int idMission = missionRepository.save(mission1).getId();

        try {
            logger.debug("testing the method");
            missionRepository.editMissionDescription("test",idMission);

            Mission updatedMission = missionRepository.findById(idMission).get();

            assertThat(updatedMission.getName()).isNotNull().isEqualTo("tooly");
            assertThat(updatedMission.getDescription()).isNotNull().isEqualTo("test");
            logger.info("testing editMissionDescription on success");
        }catch (Exception e){
            logger.error("Error in editMissionDescription causedBy"+e.getMessage());
        }
    }
}
