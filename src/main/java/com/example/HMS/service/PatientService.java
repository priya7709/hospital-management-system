package com.example.HMS.service;

import com.example.HMS.dao.PatientDao;
import com.example.HMS.models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    PatientDao patientDao;

    public Page<Patient> getAllPatients(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return patientDao.findAll(pageable);
        //List<Patient> allPatients = patientDao.findAll();
       // System.out.println("All Details of Patient" + allPatients);
       // return allPatients;
    }

    public String addpatient(Patient patient) {
        patientDao.save(patient);
        return "New Patient added";
    }

    public Patient getPatientById(Long id) {
       Optional<Patient> patientOpt = patientDao.findById(id);
       if(patientOpt.isPresent())
           return patientOpt.get();
       return null;
    }

    public void deletePatient(Long id) {
       patientDao.deleteById(id);
    }

    public Patient updatePatient(Long id, Patient updatePatient) {
        Optional<Patient> existingPatient = patientDao.findById(id);
        if (existingPatient.isPresent()){
            Patient p = existingPatient.get();
            p.setName(updatePatient.getName());
            p.setAge(updatePatient.getAge());
            p.setGender(updatePatient.getGender());
            patientDao.save(p);
            return updatePatient;
        }
        return null;
    }
}
