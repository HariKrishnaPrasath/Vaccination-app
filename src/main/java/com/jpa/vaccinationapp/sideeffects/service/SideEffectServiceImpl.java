package com.jpa.vaccinationapp.sideeffects.service;

import com.jpa.vaccinationapp.patient.Patient;
import com.jpa.vaccinationapp.patient.PatientRepository;
import com.jpa.vaccinationapp.sideeffects.SideEffect;
import com.jpa.vaccinationapp.sideeffects.SideEffectException;
import com.jpa.vaccinationapp.sideeffects.SideEffectRepository;
import com.jpa.vaccinationapp.vaccinationCenter.Center;
import com.jpa.vaccinationapp.vaccinationCenter.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SideEffectServiceImpl implements SideEffectService {

    @Autowired
    private SideEffectRepository sideEffectRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private CenterRepository centerRepository;

    @Override
    public SideEffect recordSideEffect(SideEffect sideEffect) throws SideEffectException {
        if(sideEffect == null) throw new SideEffectException("side effect cant be null");
        return this.sideEffectRepository.save(sideEffect);
    }

    @Override
    public List<SideEffect> getAllSideEffects() {
        return this.sideEffectRepository.findAll();
    }

    @Override
    public List<SideEffect> getSideEffectsByPatientId(Integer patientId) throws SideEffectException {
        if(patientId == null) throw new SideEffectException("patient ID cant be null");
        Optional<Patient> patientOpt = this.patientRepository.findById(patientId);
        if (patientOpt.isEmpty()){
            throw new SideEffectException("Patient Id not found");
        }
        return this.sideEffectRepository.findByPatient(patientOpt.get());
    }

    @Override
    public List<SideEffect> getSideEffectsByCentre(Integer centreId) throws SideEffectException {
        if(centreId == null) throw new SideEffectException("centre id cant be null");
        Optional<Center> centreOpt = this.centerRepository.findById(centreId);
        if(centreOpt.isEmpty()){
            throw new SideEffectException("center id not found");
        }
        return this.sideEffectRepository.findByCenter(centreOpt.get());
    }

}