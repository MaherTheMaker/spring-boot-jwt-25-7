package com.Maker.service;

//import com.Maker.dao.FileRepo;
import com.Maker.dao.FileRepo;
import com.Maker.dao.ImageRepo;
import com.Maker.dao.PatientRepo;
//import com.Maker.model.File;
import com.Maker.model.File;
import com.Maker.model.Image;
import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;

@Repository
public class PatientServiceImp implements PatientService {


    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private FileRepo fileRepo;

    @Autowired
    private PatientToothService patientToothService;

    @Override
    public Patient addPatient(Patient patient) {
        return
                patientRepo.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepo.findAll();
    }

    @Override
    public Patient DiagnosisOrEdit(Patient patient,int pId) {
        Patient oldPatient = patientRepo.findById(pId);

        oldPatient.setAge(patient.getAge());
        oldPatient.setDeciduousTeeth(patient.getDeciduousTeeth());
        oldPatient.setCareWays(patient.getCareWays());
        oldPatient.setHabits(patient.getHabits());
        oldPatient.setFamilyStatus(patient.getFamilyStatus());
        oldPatient.setLastVisitToADoctor(patient.getLastVisitToADoctor());
        oldPatient.setEmail(patient.getEmail());
        oldPatient.setAddress(patient.getAddress());
        oldPatient.setDiscountType(patient.getDiscountType());



       Patient result= patientRepo.save(oldPatient);

        if (result.getDeciduousTeeth()!=null)
        {
            //TODO check if not the first
           List<PatientTooth> test= patientToothService.GetPatientTeeth(pId);
           if(test.isEmpty())
            patientToothService.addPatientTooth(result);
        }


        return result;
    }


    @Override
    public List<Patient> searchPatient(String name) {
        return patientRepo.findAllByFullName(name);
    }

    @Override
    public Patient getPatient(int id) {
        return patientRepo.findById(id);
    }

    @Override
    public Image addImage(int pId, Image image) {
        Patient patient= patientRepo.findById(pId);
        image.setPatient(patient);
        Image im = imageRepo.save(image);
        if (im!=null){
           patient.getGallery().add(image);
        }
        return im;
    }

    @Override
    public File addFile(int pId, File file) {
        Patient patient = patientRepo.findById(pId);
        file.setPatient(patient);
        File fi = fileRepo.save(file);
        if (fi!=null){
            patient.getFilesList().add(file);
        }
        return fi;
    }

    @Override
    public List<Image> getAllImage(int id) {
        Patient patient = patientRepo.findById(id);
        return imageRepo.findAllByPatient(patient);
    }


    @Override
    public List<File> getAllFile(int id) {
        Patient patient = patientRepo.findById(id);
        return fileRepo.findAllByPatient(patient);
    }



}