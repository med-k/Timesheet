package tn.spring.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.spring.timesheet.entities.*;
import java.util.List;

@Repository
public interface EmployeRepository extends JpaRepository<Employe, Integer> {

    @Query(value= "SELECT count(*) FROM Employe",nativeQuery=true)
    public int countemp();

    @Query("SELECT nom FROM Employe")
    public List<String> employeNames();

    @Query("SELECT email FROM Employe")
    public List<String> employeEmail();

    @Query("SELECT u FROM Employe u WHERE u.email =?1")
    public Employe getEmployeByEmail(String email);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Employe e SET e.email=:email1 where e.id=:employeId")
    public void mettreAjourEmailByEmployeIdJPQL(@Param("email1")String email, @Param("employeId")int employeId);

}
