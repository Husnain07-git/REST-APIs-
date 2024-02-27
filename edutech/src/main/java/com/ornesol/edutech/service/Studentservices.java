package com.ornesol.edutech.service;


import com.ornesol.edutech.entity.Student;
import com.ornesol.edutech.repository.StudentRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class Studentservices {

    //accessing StudentReposity
    private StudentRepository studentRepository;

    //Creating student
    public Student create(Student student){
        return studentRepository.save(student);
    }


    //get all students
    public List<Student> getALLStu(){
        return studentRepository.findAll();
    }

    //get single student
    public ResponseEntity<Student> getStudentByID(Long id){
        Student student = studentRepository.findById(id).orElse(null);
        if (student!=null){
            return ResponseEntity.ok(student);
        }
        else {
            return ResponseEntity.notFound().build(); //return 404 if not exist
        }
    }


    //update student
    public ResponseEntity<Student>updateStudent(Long id , Student updateStudent){
        Student exitingStudent = studentRepository.findById(id).orElse(null);
        if(exitingStudent!= null)
        {

            exitingStudent.setStudentName(updateStudent.getStudentName() );
            exitingStudent.setFatherName(updateStudent.getFatherName() );
            exitingStudent.setPhoneNum(updateStudent.getPhoneNum() );
            exitingStudent.setCNIC(updateStudent.getCNIC() );
            exitingStudent.setAddress(updateStudent.getAddress() );
            Student saveStudent = studentRepository.save(exitingStudent);

            return ResponseEntity.ok(saveStudent); //200 success
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }


    //delete
    public ResponseEntity<Void> deleteStuByID( Long id){
        if (studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }else {
            return ResponseEntity.notFound().build();
        }
    }


}
