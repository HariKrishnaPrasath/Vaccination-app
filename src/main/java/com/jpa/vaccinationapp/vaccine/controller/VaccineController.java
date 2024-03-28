package com.jpa.vaccinationapp.vaccine.controller;

import com.jpa.vaccinationapp.admin.Admin;
import com.jpa.vaccinationapp.vaccine.Vaccine;
import com.jpa.vaccinationapp.vaccine.VaccineException;
import com.jpa.vaccinationapp.vaccine.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})

public class VaccineController {
    @Autowired
    private  VaccineService vaccineService;

    @PostMapping("vaccine/create")
    public Vaccine createVaccine(@RequestBody Vaccine newVaccine) throws VaccineException {
        return vaccineService.createVaccine(newVaccine);
    }
    @PutMapping("vaccine/update/{vaccineId}")
    public Vaccine updateVaccine(@PathVariable Integer vaccineId, @RequestBody Vaccine vaccine) throws VaccineException{
        return vaccineService.updateVaccine(vaccineId, vaccine);
    }
    @GetMapping("vaccine/{id}")
    public Vaccine getById(@PathVariable Integer id) throws VaccineException{
        return vaccineService.getById(id);
    }
    @GetMapping("vaccine/getByName/{name}")
    public List<Vaccine> getByName(@PathVariable String vaccineName) throws VaccineException{
        return vaccineService.getByName(vaccineName);
    }
    @DeleteMapping("vaccine/deleteExpiredVaccine")
    public List<Vaccine> deleteExpiredVaccines() throws VaccineException{
        return vaccineService.deleteExpiredVaccines();
    }
    @DeleteMapping("vaccine/deleteById/{vaccineId}")
    public Vaccine deleteById(@PathVariable Integer vaccineId) throws VaccineException{
        return vaccineService.deleteById(vaccineId);
    }
    @GetMapping("vaccine/getAllvaccine")
    public List<Vaccine> getAllVaccine(){
        return vaccineService.getAllVaccine();
    }

}
