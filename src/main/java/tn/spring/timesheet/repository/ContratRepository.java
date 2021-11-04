package tn.spring.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.spring.timesheet.entities.Contrat;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

    @Query(value= "SELECT count(*) FROM Contrat",nativeQuery=true)
    public int countcont();

    @Query("SELECT c FROM Contrat c WHERE c.typeContrat =?1")
    public Contrat getContratByType(String type);

}
