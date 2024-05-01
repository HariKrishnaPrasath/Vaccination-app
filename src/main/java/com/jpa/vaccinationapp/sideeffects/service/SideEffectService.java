package com.jpa.vaccinationapp.sideeffects.service;

import com.jpa.vaccinationapp.sideeffects.SideEffect;
import com.jpa.vaccinationapp.sideeffects.SideEffectException;

import java.util.List;

public interface SideEffectService {

    SideEffect recordSideEffect(SideEffect sideEffect) throws SideEffectException;
    List<SideEffect> getAllSideEffects();
    List<SideEffect> getSideEffectsByPatientId(Integer patientId) throws SideEffectException;
    List<SideEffect> getSideEffectsByCentre(Integer centreId) throws SideEffectException;
}
