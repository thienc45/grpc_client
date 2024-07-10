package com.example.send.grpcclient.client;

import com.example.send.grpc_student.Empty;
import com.example.send.grpc_student.Student;
import com.example.send.grpc_student.StudetnPointGrpc;
import com.example.send.grpc_student.UserList;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Iterator;

public class GrpcClient {
    public static void main(String[] args) {
        // Thiết lập kênh gRPC đến server
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext() // Sử dụng kết nối không bảo mật (plaintext), không dùng trong production
                .build();

        // Tạo stub cho dịch vụ
        StudetnPointGrpc.StudetnPointBlockingStub stub = StudetnPointGrpc.newBlockingStub(channel);

        // Tạo request
        Empty request = Empty.newBuilder().build();

        // Gửi request và nhận phản hồi từ server
        UserList userList = stub.getUsers(request);

        // In ra danh sách sinh viên từ phản hồi
        Iterator<Student> iterator = userList.getStudentList().iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            System.out.println("Student ID: " + student.getId() + ", Point: " + student.getPoint());
        }

        // Đóng kênh gRPC khi hoàn thành
        channel.shutdown();
    }
}
