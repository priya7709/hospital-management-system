package com.example.HMS.service;

import com.example.HMS.dao.DoctorDao;
import com.example.HMS.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorDao doctorDao;

    public List<Doctor> getAllDoctorDetails() {
       return doctorDao.findAll();
    }

    public String addDoctor(Doctor doctor) {
         doctorDao.save(doctor);
         return "New Doctor Details added";
    }

    public void deleteById(Long id) {
        doctorDao.deleteById(id);
    }

    public Doctor getDoctorDetailsById(Long id) {
       Optional<Doctor> doctorOptional = doctorDao.findById(id);
       if(doctorOptional.isPresent())
           return doctorOptional.get();
       return null;
    }

    public Doctor updateDoctor(Long id, Doctor updateDoctor) {
        Optional<Doctor> existingDoctor = doctorDao.findById(id);
        if(existingDoctor.isPresent()){
            Doctor d = existingDoctor.get();
            d.setName(updateDoctor.getName());
            d.setSpeciality(updateDoctor.getSpeciality());
            doctorDao.save(d);
            return updateDoctor;
        }
        return null;
    }
}
