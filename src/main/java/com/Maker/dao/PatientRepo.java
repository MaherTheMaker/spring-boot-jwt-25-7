package com.Maker.dao;

import com.Maker.model.Clinic;
import com.Maker.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface PatientRepo extends JpaRepository<Patient, Integer> {

    List<Patient> findAllByFullName(String username);
    Patient findById(int id);


}
