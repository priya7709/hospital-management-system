package com.example.HMS.controller;

import com.example.HMS.models.Appointment;
import com.example.HMS.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;

    @GetMapping
    public List<Appointment> getAllAppointmentDetails() {
        return appointmentService.getAllAppointmentDetails();
    }

    @PostMapping("add")
    public String createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }

    @GetMapping("get/{id}")
    public Appointment getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @DeleteMapping("delete/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentService.deleteAppointment(id);
        System.out.println("Record Deleted");
    }

    @PutMapping("update/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment updateAppointment) {
        return appointmentService.updateAppointment(id, updateAppointment);
    }
}
