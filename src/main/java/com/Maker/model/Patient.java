package com.Maker.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String fullName;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String phoneNumber;
    private String email;
    private String address;
    @Column(nullable = false)
    private short age;


    private Boolean DeciduousTeeth;
    private String familyStatus;
    private float balance = 0.0f ;
    private String discountType;

    public Patient(String fullName, Gender gender, String phoneNumber, String email, String address, short age, Boolean deciduousTeeth, String familyStatus, float balance, String discountType, List<Image> gallery, List<File> filesList) {
        this.fullName = fullName;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.age = age;
        DeciduousTeeth = deciduousTeeth;
        this.familyStatus = familyStatus;
        this.balance = balance;
        this.discountType = discountType;
        this.gallery = gallery;
        this.filesList = filesList;
    }

    public Patient() {
    }

    public Boolean getDeciduousTeeth() {
        return DeciduousTeeth;
    }

    public void setDeciduousTeeth(Boolean deciduousTeeth) {
        DeciduousTeeth = deciduousTeeth;
    }

    public void setFilesList(List<File> filesList) {
        this.filesList = filesList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public String getFamilyStatus() {
        return familyStatus;
    }

    public void setFamilyStatus(String familyStatus) {
        this.familyStatus = familyStatus;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

        @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Image> gallery;

    public List<Image> getGallery() {
        return gallery;
    }

    public void setGallery(List<Image> gallery) {
        this.gallery = gallery;
    }


    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<File> filesList;

    public List<File> getFilesList() {
        return filesList;
    }

//    public void setFilesList(List<File> filesList) {
//        this.filesList = filesList;
//    }
    //    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PatientTooth> toothList;
//
//    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<PIllness> MedHistory;

}
