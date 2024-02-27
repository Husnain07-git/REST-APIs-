package com.ornesol.edutech.controller;


import com.ornesol.edutech.entity.Student;
import com.ornesol.edutech.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/demo/student")
public class StudentController {

@Autowired
public StudentRepository studentDetailRepository;

//add student
    @PostMapping("/add")
    public Student addStudent(@RequestBody  Student student){

        return  studentDetailRepository.save(student);

    }

//getAllStudents
    @GetMapping("/getAllst")
    public List<Student> getALLStu(){

        return studentDetailRepository.findAll();
    }

//getStudent

@GetMapping("/getstu/{id}")
public ResponseEntity<Student> getStudentByID(@PathVariable Long id){
Student student = studentDetailRepository.findById(id).orElse(null);
    if (student!=null){
    return ResponseEntity.ok(student);
    }
    else {
    return ResponseEntity.notFound().build(); //return 404 if not exist
    }
}

//update student
@PutMapping("/updateStu/{id}")
//    public ResponseEntity<Student>updateStudent(@PathVariable Long id , @RequestBody Student updateStudent){
public ResponseEntity<Student>updateStudent(@PathVariable Long id , @RequestBody Student updateStudent){


Student exitingStudent = studentDetailRepository.findById(id).orElse(null);
    if(exitingStudent!= null)
    {
        exitingStudent.setStudentName(updateStudent.getStudentName() );
        exitingStudent.setFatherName(updateStudent.getFatherName() );
        exitingStudent.setPhoneNum(updateStudent.getPhoneNum() );
        exitingStudent.setCNIC(updateStudent.getCNIC() );
        exitingStudent.setAddress(updateStudent.getAddress() );


    Student saveStudent = studentDetailRepository.save(exitingStudent);

    return ResponseEntity.ok(saveStudent); //200 success
    }
    else {
    return ResponseEntity.notFound().build();
    }

}

//delete
@DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStuByID(@PathVariable Long id){
        if (studentDetailRepository.existsById(id)){
            studentDetailRepository.deleteById(id);
            return ResponseEntity.noContent().build();

        }else {
            return ResponseEntity.notFound().build();
        }
}

@GetMapping("/check")
public String check()
{
        return "Succeccfull";
}

}
