package tn.spring.timesheet.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.timesheet.Mapper;
import tn.spring.timesheet.entities.Contrat;
import tn.spring.timesheet.entities.ContratDTO;
import tn.spring.timesheet.entities.Employe;
import tn.spring.timesheet.services.IContratService;

import java.util.List;

@AllArgsConstructor
@RestController
public class ContratController {
    private final IContratService iContratService ;
    private Mapper mapper ;


    //Add Contract
    @PostMapping("/addcontract")
    @ResponseBody
    public Contrat addContrat( ContratDTO contratDTO) {
        Contrat contrat = mapper.toContrat(contratDTO) ;
        return iContratService.addContrat(contrat) ;
    }

    //Get All Contracts : http://localhost:8055/SpringMVC/servlet/getallcontracts
    @GetMapping(value = "/getallcontracts")
    @ResponseBody
    public List<Contrat> getAllContrat() {
        return iContratService.getAllContrat() ;
    }

    // Count Contracts
    @GetMapping(value = "/countcontracts")
    @ResponseBody
    public int getNombreContrat() {
        return  iContratService.countContrat();
    }

    // Get Contract by Type
    @GetMapping(value = "/getcontractbytype/{type}")
    @ResponseBody
    public Contrat getContratByType(@PathVariable("type") String type) {
        return  iContratService.getByType(type); }

}
