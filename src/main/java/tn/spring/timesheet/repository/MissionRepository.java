package tn.spring.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.spring.timesheet.entity.Mission;

import java.util.List;

@Repository
public interface MissionRepository extends JpaRepository<Mission,Integer> {
    @Query(value="SELECT count(*) FROM mission",nativeQuery = true)
    public int countMission();

    @Query("SELECT DISTINCT m.name FROM Mission m")
    public List<String> getAllNamesOfMission();

    @Modifying(clearAutomatically = true)
    @Query("update Mission u set  u.description = :description where u.id = :id")
    public Mission editMissionDescription(@Param("description")String description, @Param("id")  int id);



}
