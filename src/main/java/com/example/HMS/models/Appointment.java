package com.example.HMS.models;

import jakarta.persistence.*;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name="doctorId")
    private Doctor doctor;

    public Appointment(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment(Patient patient) {
        this.patient = patient;
    }

    public Appointment(){}

    public Appointment(Long id, String date, Patient patient, Doctor doctor) {
        this.id = id;
        this.date = date;
        this.patient = patient;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", patient=" + (patient != null ? patient.getId() : null) +
                ", doctor=" + (doctor != null ? doctor.getId() : null) +
                '}';
    }
}
