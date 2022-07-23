package com.Maker.service;

import com.Maker.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientService {

    Patient addPatient(Patient patient);
    List<Patient> getAllPatients();

    List<Patient> searchPatient(String name);

    Patient getPatient(int id);

    Image addImage(int pId ,Image image);
    File addFile(int pId , File file);
    List<Image> getAllImage(int id);
    List<File> getAllFile(int id);

}

