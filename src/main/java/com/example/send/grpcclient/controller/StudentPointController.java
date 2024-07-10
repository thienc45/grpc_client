package com.example.send.grpcclient.controller;

import com.example.ecommerce.ProductRequest;
import com.example.ecommerce.ProductResponse;
import com.example.send.grpcclient.entity.Student;
import com.example.send.grpcclient.service.StudentPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/student-point")
public class StudentPointController {
    private final StudentPointService studentPointService;

    @Autowired
    public StudentPointController(StudentPointService studentPointService) {
        this.studentPointService = studentPointService;
    }


    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentPointService.getUsers();
        return ResponseEntity.ok(students);
    }

    @PostMapping("/addpoint")
    public ResponseEntity<String> addPointStudent(@RequestBody Student student) {
        studentPointService.addStudent(student);
        return ResponseEntity.ok("Student added successfully");
    }

    @PostMapping("/deletepoint")
    public ResponseEntity<Student> deltePointStudent(@RequestBody Student student) {
      Student student1=  studentPointService.deletePointStudent(student);
        return ResponseEntity.ok(student1);
    }



}
