package com.example.HMS.service;

import com.example.HMS.dao.AppointmentDao;
import com.example.HMS.models.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    AppointmentDao appointmentDao;
    public List<Appointment> getAllAppointmentDetails() {
        return appointmentDao.findAll();
    }

    public String addAppointment(Appointment appointment) {
        appointmentDao.save(appointment);
        return "New Appointment Created";
    }

    public Appointment getAppointmentById(Long id) {
        Optional<Appointment> appointmentOptional = appointmentDao.findById(id);
        if (appointmentOptional.isPresent()){
            return appointmentOptional.get();
        }
        return null;
    }

    public void deleteAppointment(Long id) {
        appointmentDao.deleteById(id);
    }

    public Appointment updateAppointment(Long id, Appointment updateAppointment) {
        Optional<Appointment> existingAppointment = appointmentDao.findById(id);
        if(existingAppointment.isPresent()){
            Appointment a = existingAppointment.get();
            a.setDate(updateAppointment.getDate());
            a.setPatient(updateAppointment.getPatient());
            a.setDoctor(updateAppointment.getDoctor());
            appointmentDao.save(a);
            return updateAppointment;
        }
        return null;
    }
}
