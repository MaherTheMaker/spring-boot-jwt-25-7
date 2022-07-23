package com.Maker.controller;

import com.Maker.dao.PatientRepo;
import com.Maker.model.*;

import com.Maker.service.PatientService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PatientRepo patientRepo;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>>getClinics ( ) {
        return ResponseEntity.ok().body(patientService.getAllPatients());
    }

    @PostMapping("/save")
    public ResponseEntity<Patient> addClinic(@RequestBody Patient patient){
        return ResponseEntity.ok().body(patientService.addPatient(patient));
    }



    @PostMapping("/searchPatient/{username}")
    public ResponseEntity<List<Patient>> getPlan(@PathVariable String username){
        return ResponseEntity.ok().body(patientService.searchPatient(username));
    }


    @PostMapping("/{pId}/addImage")
    public ResponseEntity addImage (@PathVariable int pId , @RequestBody Image image){
        return ResponseEntity.ok().body(patientService.addImage(pId,image));
    }

    @PostMapping("/{pId}/addFile")
    public ResponseEntity addFile (@PathVariable int pId , @RequestBody File file){
        return ResponseEntity.ok().body(patientService.addFile(pId,file));
    }

    @GetMapping("/{pId}/getAllImage")
    public ResponseEntity<List<Image>>getGallery (@PathVariable int pId){
        return ResponseEntity.ok().body(patientService.getAllImage(pId));
    }

    @GetMapping("/{pId}/getAllFiles")
    public ResponseEntity<List<File>>getFiles (@PathVariable int pId){
        return ResponseEntity.ok().body(patientService.getAllFile(pId));
    }



}
