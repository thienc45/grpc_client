package com.example.send.grpcclient.service;

import com.example.ecommerce.ProductRequest;
import com.example.ecommerce.ProductResponse;
import com.example.send.grpc_student.Empty;
import com.example.send.grpc_student.PointRequest;
import com.example.send.grpc_student.PointResponse;

import com.example.send.grpc_student.StudetnPointGrpc;
import com.example.send.grpc_student.UserList;
import com.example.send.grpcclient.entity.Student;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentPointService {

    private final StudetnPointGrpc.StudetnPointBlockingStub studentsService;

    @Autowired
    public StudentPointService(ManagedChannel channel) {
        this.studentsService = StudetnPointGrpc.newBlockingStub(channel);
    }


    public List<Student> getUsers() {
        Empty request = Empty.newBuilder().build();
        UserList userList = studentsService.getUsers(request);

        return userList.getStudentList().stream()
                .map(student -> new Student(student.getId(), student.getPoint(), student.getMessage()))
                .collect(Collectors.toList());
    }

    // Method to add a new student
    public void addStudent(Student request) {
        // Prepare PointRequest based on request
        PointRequest pointRequest = PointRequest.newBuilder()
                .setId(request.getId())
                .setPoint(request.getPoint())
                .build();

        // Perform gRPC call to add student
        PointResponse response = studentsService.addPoints(pointRequest);

        // Handle response as needed
        System.out.println("Response message: " + response.getMessage());
    }

    // Method to add a new student
    public Student deletePointStudent(Student request) {
        // Prepare PointRequest based on request
        PointRequest pointRequest = PointRequest.newBuilder()
                .setId(request.getId())
                .setPoint(request.getPoint())
                .build();

        // Perform gRPC call to add student
        PointResponse response = studentsService.subtractPoints(pointRequest);

        // Handle response as needed
        System.out.println("Response message: " + response.getMessage());
        return request;
    }




}
