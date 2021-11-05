package tn.spring.timesheet.service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import tn.spring.timesheet.entity.Mission;
import tn.spring.timesheet.repository.MissionRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class MissionServiceImpl implements  IMissionService{
    private static final Logger logger = LogManager.getLogger(IMissionService.class);

    private final MissionRepository missionRepoistory;

    @Override
    public int getNombreMission() {
        logger.info("In getNombreMission");

        try {
            logger.debug("getting number of Mission");
            int nbrMission = missionRepoistory.countMission();
            logger.info("Out getNombreMission with success");
            return nbrMission;
        }catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }

    @Override
    public List<String> getAllMissionNames() {
        logger.info("In getAllMissionNames");

        try {
            logger.debug("getting Mission name");
            List<String> MissionList = missionRepoistory.getAllNamesOfMission();
            logger.info("Out getAllMissionNames with success");
            return MissionList;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Mission AddMission(Mission mission) {
        logger.info("In ajouterMission");

        try {
            logger.debug("adding  entity");
            Mission addedMission = missionRepoistory.save(mission);
            logger.info("Out addMission with success");
            return addedMission;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Mission> GetAllMission() {
        logger.info("In GetAllMission");

        try {
            logger.debug("getting all Mission");
            List<Mission> listMission = missionRepoistory.findAll();
            logger.info("Out getAllMission with success");
            return listMission;
        }catch (Exception e){
            logger.error(e.getMessage());
            return new ArrayList<>();
        }
    }

    @Override
    public Mission GetMissionById(int MissionId) {
        logger.info("In getMissionById");

        try {
            logger.debug("getting Mission by id");
            Optional<Mission> value = missionRepoistory.findById(MissionId);
            if(value.isPresent()){
                Mission mission = value.get();
                logger.info("Out getMissionById with success");
                return mission;
            }else{
                return null;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    @Override
    public void DeleteMissionById(int MissionId) {
        logger.info("In DeleteMissionById");

        try {
            logger.debug("deleting Mission   by id");
            missionRepoistory.deleteById(MissionId);
            logger.info("Out DeleteMissionById with success");
        }catch (Exception e){
            logger.error(e.getMessage());
        }

    }

    @Override
    public Mission editMissionDescriptionById(String description, int id) {
        logger.info("In editMissionDescriptionById");

        try {
            logger.debug("editting Mission description  by id");
            missionRepoistory.editMissionDescription(description,id);
            logger.info("Out editMissionDescriptionById with success");
            Optional<Mission> value =  missionRepoistory.findById(id);
            if(value.isPresent()){
                return value.get();
            }else{
                return null;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
