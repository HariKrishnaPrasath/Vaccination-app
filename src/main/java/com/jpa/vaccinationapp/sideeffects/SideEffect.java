package com.jpa.vaccinationapp.sideeffects;

import com.jpa.vaccinationapp.appointment.Appointment;
import com.jpa.vaccinationapp.patient.Patient;
import jakarta.persistence.*;

@Entity
public class SideEffect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToOne
    private Patient patient;

    @ManyToOne
    private Appointment booking;

    public SideEffect(String description, Patient patient, Appointment booking) {
        this.description = description;
        this.patient = patient;
        this.booking = booking;
    }

    public SideEffect(Long id, String description, Patient patient, Appointment booking) {
        this.id = id;
        this.description = description;
        this.patient = patient;
        this.booking = booking;
    }

    public SideEffect() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getBooking() {
        return booking;
    }

    public void setBooking(Appointment booking) {
        this.booking = booking;
    }
}
