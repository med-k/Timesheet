package tn.spring.timesheet.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.timesheet.entities.Entreprise;
import tn.spring.timesheet.services.IEntrepriseService;
import java.util.List;


@AllArgsConstructor
@RestController
public class RestControlEntreprise {


    private final IEntrepriseService ientrepriseservice;


    // http://localhost:8081/SpringMVC/servlet/ajouterEntreprise
    @PostMapping("/ajouterEntreprise")
    @ResponseBody
    public Entreprise ajouterEntreprise(@RequestBody Entreprise entreprise) {
        Entreprise addedEntreprise = ientrepriseservice.ajouterEntreprise(entreprise);
        return addedEntreprise;
    }

    // http://localhost:8081/SpringMVC/servlet/geAllEntreprise
    @GetMapping(value = "/geAllEntreprise")
    @ResponseBody
    public List<Entreprise> getEntrepriseById() {
        return  ientrepriseservice.getAllEntreprise();
    }

    // http://localhost:8081/SpringMVC/servlet/getAllEntrepriseNames
    @GetMapping(value = "/getAllEntrepriseNames")
    @ResponseBody
    public List<String> getAllEntrepriseNames() {
        return  ientrepriseservice.getAllEntrepriseNames();
    }

    // http://localhost:8081/SpringMVC/servlet/getNombreEntreprise
    @GetMapping(value = "/getNombreEntreprise")
    @ResponseBody
    public int getNombreEntreprise() {
        return  ientrepriseservice.getNombreEntreprise();
    }

    // http://localhost:8081/SpringMVC/servlet/getAllEntrepriseByRaisonSocial/tictactrip
    @GetMapping(value = "/getAllEntrepriseByRaisonSocial/{name}")
    @ResponseBody
    public List<Entreprise> getAllEntrepriseByRaisonSocial(@PathVariable("raisonSocial") String raisonSocial) {
        return  ientrepriseservice.getAllEntrepriseByRaisonSocial(raisonSocial);
    }

    // http://localhost:8081/SpringMVC/servlet/getEntrepriseById/1
    @GetMapping(value = "/getEntrepriseById/{id}")
    @ResponseBody
    public Entreprise getEntrepriseById(@PathVariable("id") int id) {
        Entreprise entreprise = ientrepriseservice.getEntrepriseById(id);
        return  entreprise;
    }

    // http://localhost:8081/SpringMVC/servlet/editEntreprise/1
    @PutMapping(value = "/editEntreprise/{id}")
    @ResponseBody
    public Entreprise editEntrepriseById(@PathVariable("id") int id,@RequestBody Entreprise entreprise) {
        return  ientrepriseservice.editEntrepriseById(entreprise,id);
    }

    // http://localhost:8081/SpringMVC/servlet/editEntrepriseNameById/1
    @PutMapping(value = "/editEntrepriseNameById/{id}")
    @ResponseBody
    public Entreprise editEntrepriseNameById(@PathVariable("id") int id,@RequestBody String name) {
        Entreprise entreprise = ientrepriseservice.editEntrepriseNameById(name,id);
        return entreprise;
    }

    // http://localhost:8081/SpringMVC/servlet/deleteEntrepriseById/1
    @DeleteMapping("/deleteEntrepriseById/{id}")
    @ResponseBody
    public void deleteEntrepriseById(@PathVariable("id")int id)
    {
        ientrepriseservice.deleteEntrepriseById(id);
    }

    // URL : http://localhost:8081/SpringMVC/servlet/deleteAllEntreprise
    @DeleteMapping("/deleteAllEntreprise")
    public void deleteAllEntreprise() {
        ientrepriseservice.deleteAllEntreprise();
    }


}
