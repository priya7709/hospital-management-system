package com.example.HMS.controller;

import com.example.HMS.models.Doctor;
import com.example.HMS.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @GetMapping
    public List<Doctor> getAllDoctorDetails() {
        return doctorService.getAllDoctorDetails();
    }

    @PostMapping("add")
    public String createDoctor(@RequestBody Doctor doctor) {
        return doctorService.addDoctor(doctor);
    }

    @DeleteMapping("delete/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorService.deleteById(id);
        System.out.println("Record Deleted");
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorDetailsById(id);
    }

    @PutMapping("update/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor updateDoctor) {
        return doctorService.updateDoctor(id, updateDoctor);
    }
}
