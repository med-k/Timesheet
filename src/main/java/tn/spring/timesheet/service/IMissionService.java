package tn.spring.timesheet.service;

import tn.spring.timesheet.entity.Mission;

import java.util.List;

public interface IMissionService {

    public int getNombreMission();
    public List<String> getAllMissionNames();
    public Mission editMissionDescriptionById(String description,  int id);
    public Mission AddMission(Mission m);
    public void DeleteMissionById(int MissionId);
    public List<Mission> GetAllMission( );
    public Mission GetMissionById( int MissionId );


}
