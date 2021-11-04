package tn.spring.timesheet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.spring.timesheet.entities.Departement;
import org.springframework.data.jpa.repository.Modifying;

import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Departement, Integer>{

    @Query(value = "SELECT count (*) FROM Departement",nativeQuery = true)
    public int countDep();

    @Query("SELECT name FROM Departement")
    public List<String> DepartmentNames();


    @Modifying(clearAutomatically = true)
    @Query("UPDATE Departement d SET d.name=:name1 where d.id=:departmentId")
    public void mettreAjourNameByDepartmentIdJPQL(@Param("name1")String name, @Param("departmentId")int id);




}
