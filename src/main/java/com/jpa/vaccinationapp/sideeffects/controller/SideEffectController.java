package com.jpa.vaccinationapp.sideeffects.controller;

import com.jpa.vaccinationapp.sideeffects.SideEffect;
import com.jpa.vaccinationapp.sideeffects.SideEffectException;
import com.jpa.vaccinationapp.sideeffects.service.SideEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
@RequestMapping("/sideEffects")
public class SideEffectController {
    @Autowired
    private SideEffectService sideEffectService;

    @PostMapping
    public ResponseEntity<SideEffect> recordSideEffect(@RequestBody SideEffect sideEffect)throws SideEffectException{
        return ResponseEntity.ok(sideEffectService.recordSideEffect(sideEffect));
    }
    @GetMapping("/all")
    public List<SideEffect> getAllSideEffect(){return this.sideEffectService.getAllSideEffects();}

    @GetMapping("/{id}")
    public List<SideEffect> getSideEffectById(@PathVariable("id") Integer patientId)throws SideEffectException{
        return this.sideEffectService.getSideEffectsByPatientId(patientId);
    }
    @GetMapping("/center/{id}")
    public List<SideEffect> getSideEffectByCenterId(@PathVariable("id") Integer centerId)throws SideEffectException{
        return this.sideEffectService.getSideEffectsByCentre(centerId);
    }
}
