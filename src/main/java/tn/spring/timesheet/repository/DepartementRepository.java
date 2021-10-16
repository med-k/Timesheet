package tn.spring.timesheet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.spring.timesheet.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
}
