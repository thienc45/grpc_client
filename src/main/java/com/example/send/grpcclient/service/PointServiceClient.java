package com.example.send.grpcclient.service;

import com.example.send.grpcclient.entity.User;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;
import pointservice.PointServiceGrpc;
import pointservice.PointServiceOuterClass;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointServiceClient {
    private final PointServiceGrpc.PointServiceBlockingStub pointServiceBlockingStub;

    public PointServiceClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.100.227", 50051)
                .usePlaintext()
                .build();
        pointServiceBlockingStub = PointServiceGrpc.newBlockingStub(channel);
    }

    public int addPoints(String userId, int points) {
        PointServiceOuterClass.PointRequest request = PointServiceOuterClass.PointRequest.newBuilder()
                .setUserId(userId)
                .setPoints(points)
                .build();
        PointServiceOuterClass.PointResponse response = pointServiceBlockingStub.addPoints(request);
        return response.getTotalPoints();
    }

    public int subtractPoints(String userId, int points) {
        PointServiceOuterClass.PointRequest request = PointServiceOuterClass.PointRequest.newBuilder()
                .setUserId(userId)
                .setPoints(points)
                .build();
        PointServiceOuterClass.PointResponse response = pointServiceBlockingStub.subtractPoints(request);
        return response.getTotalPoints();
    }

    public List<User> getUsers() {
        PointServiceOuterClass.Empty request = PointServiceOuterClass.Empty.newBuilder().build();
        PointServiceOuterClass.UserList response = pointServiceBlockingStub.getUsers(request);
        return response.getUsersList().stream()
                .map(user -> new User(user.getUserId(), user.getTotalPoints()))
                .collect(Collectors.toList());
    }
}
