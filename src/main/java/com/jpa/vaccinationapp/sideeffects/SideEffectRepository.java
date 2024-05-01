package com.jpa.vaccinationapp.sideeffects;

import com.jpa.vaccinationapp.patient.Patient;
import com.jpa.vaccinationapp.vaccinationCenter.Center;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SideEffectRepository extends JpaRepository<SideEffect,Long> {
    List<SideEffect> findByPatient(Patient patient);
    @Query("select s from SideEffect s where s.booking.slot.center =:center")
    List<SideEffect> findByCenter(Center center);
}
