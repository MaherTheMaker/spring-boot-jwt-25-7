package com.Maker.service;

import com.Maker.dao.PatientToothRepo;
import com.Maker.dao.ToothRepo;
import com.Maker.model.Patient;
import com.Maker.model.PatientTooth;
import com.Maker.model.Tooth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PatientToothImp implements PatientToothService {




        @Autowired
        private PatientToothRepo patientToothRepo ;

        @Autowired
        private ToothRepo toothRepo;


        @Override
        public String addPatientTooth(Patient patient) {
            if(patient.getDeciduousTeeth()) {

                for (int i = 1; i <= 20 ; i++ ){
                    patientToothRepo.save(new PatientTooth(toothRepo.findById(i).getToothNumber(),patient.getId(),null,null,null));
            }

        }
            else for (int i = 21 ; i<=53 ; i++){
                patientToothRepo.save(new PatientTooth(toothRepo.findById(i).getToothNumber(),patient.getId(),null,null,null));
            }
            return "Done";
    }

}
