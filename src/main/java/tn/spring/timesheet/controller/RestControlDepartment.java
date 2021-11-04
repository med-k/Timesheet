package tn.spring.timesheet.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.spring.timesheet.Mapper;
import java.util.List;
import tn.spring.timesheet.entities.Departement;
import tn.spring.timesheet.entities.DepartementDTO;
import tn.spring.timesheet.Service.IDepartmentService;

@AllArgsConstructor
@RestController
public class RestControlDepartment {
    private final IDepartmentService iDepartmentService;
    private Mapper mapper;

    @PostMapping("/ajouterDepartment")
    @ResponseBody
    public Departement ajouterDepartment(@RequestBody DepartementDTO departementDTO) {
        Departement departement = mapper.toDepartement(departementDTO);
        return  iDepartmentService.ajouterDepartement(departement);
    }

    @GetMapping(value = "/getAllDepartmentNames")
    @ResponseBody
    public List<String> DepartmentNames() {
        return  iDepartmentService.DepartmentNames();
    }

    @GetMapping(value = "/getAllDepartment")
    @ResponseBody
    public List<Departement> getAllDepartementbyid() {
        return  iDepartmentService.getAllDepartement();
    }

    @GetMapping(value = "/getNombreDepartment")
    @ResponseBody
    public int getcountDep() {
        return  iDepartmentService.countDep();
    }
}
