package com.Maker.model;

import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;


//Todo Bean just for one time  add Teeth list
@Entity
public class Tooth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true,nullable = false)
    private int toothNumber;

    @Column(nullable = false,length = 50)
    private String type;

    @Column(unique = true,nullable = false,length = 25)
    private String name;


    public Tooth(int toothNumber, String type, String name) {
        this.toothNumber = toothNumber;
        this.type = type;
        this.name = name;
    }


    public int getToothNumber() {
        return toothNumber;
    }

    public void setToothNumber(int toothNumber) {
        this.toothNumber = toothNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Tooth() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }
}
