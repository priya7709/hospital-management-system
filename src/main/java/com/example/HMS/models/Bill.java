package com.example.HMS.models;

import jakarta.persistence.*;

@Entity
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount;
    private String status;
    @ManyToOne
    @JoinColumn(name="patientId")
    private Patient patient;

    public Bill(Patient patient) {
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Bill(){}

    public Bill(Long id, double amount, String status, Patient patient) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.patient = patient;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", patient=" + (patient != null ? patient.getId() : null) +
                '}';
    }
}
