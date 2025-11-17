package com.example.HMS.controller;

import com.example.HMS.models.Patient;
import com.example.HMS.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/patients")
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping
    public Page<Patient> getAllPatients(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue = "2") int size){
        System.out.println("Fetching Patient Details");
        return patientService.getAllPatients(page, size);
    }

    @PostMapping("add")
    public String createPatient(@RequestBody Patient patient){
        return patientService.addpatient(patient);
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deletePatient(@PathVariable Long id){
         patientService.deletePatient(id);
         System.out.println("Patient Deleted");
    }

    @PutMapping("update/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient updatePatient){
        return patientService.updatePatient(id,updatePatient);
    }
}
