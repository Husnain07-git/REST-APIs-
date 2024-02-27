package com.ornesol.edutech.controller;


import com.ornesol.edutech.entity.Student;
import com.ornesol.edutech.service.Studentservices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StuController {

    private Studentservices studentservices;

    //create student
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student){
        return  studentservices.create(student);
    }

    //getAll Student
    @GetMapping("/get")
    public List<Student> getALL(){
        return studentservices.getALLStu();
    }

    //getSingleStudent
    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return studentservices.getStudentByID(id);
    }

    //Update student
    @PostMapping("/update/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student updateStudent){
        return studentservices.updateStudent(id,updateStudent);
    }
    //delete
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStuByID(@PathVariable Long id){
       return studentservices.deleteStuByID(id);
    }

    @GetMapping("/check")
    public String check()
    {
        return "Succeccfull";
    }

}
