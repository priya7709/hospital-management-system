package com.example.HMS.dao;

import com.example.HMS.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDao extends JpaRepository<Patient, Long> {

//    Patient findById(Long id);

//    @Query(value = "SELECT * from patient p where p.id = :id", nativeQuery = true)
//    Patient findPatientById(@Param("id") Long id);

}
