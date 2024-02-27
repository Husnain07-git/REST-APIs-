package com.ornesol.edutech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentID;

    private String studentName;
    private String fatherName;
    private int phoneNum;
    private int CNIC ;
    private String address;


    public Student(Long studentID, String studentName, String fatherName, int phoneNum, int CNIC, String address, LocalDate dob) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.fatherName = fatherName;
        this.phoneNum = phoneNum;
        this.CNIC = CNIC;
        this.address = address;

    }

    public Student() {

    }

    public Long getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getFatherName() {
        return fatherName;
    }

    public int getPhoneNum() {
        return phoneNum;
    }

    public int getCNIC() {
        return CNIC;
    }

    public String getAddress() {
        return address;
    }



    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setCNIC(int CNIC) {
        this.CNIC = CNIC;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", phoneNum=" + phoneNum +
                ", CNIC=" + CNIC +
                ", address='" + address + '\'' +

                '}';
    }
}
