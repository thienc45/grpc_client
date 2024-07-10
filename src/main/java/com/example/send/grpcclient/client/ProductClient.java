package com.example.send.grpcclient.client;

import com.example.ecommerce.ProductIdRequest;
import com.example.ecommerce.ProductRequest;
import com.example.ecommerce.ProductResponse;
import com.example.ecommerce.ProductServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class ProductClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(9090)
                .addService(new ProductServiceImpl())
                .build();

        System.out.println("Starting server...");
        server.start();
        System.out.println("Server started on port " + server.getPort());
        server.awaitTermination();
    }

    static class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
        @Override
        public void getProduct(ProductIdRequest request, StreamObserver<ProductResponse> responseObserver) {
            // Create a sample response
            ProductResponse response = ProductResponse.newBuilder()
                    .setId(request.getId())
                    .setName("Sample Product")
                    .setPrice(99.99)
                    .setDescription("This is a sample product.")
                    .build();

            // Send the response
            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }

        @Override
        public void addProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
            // Implement addProduct logic
            ProductResponse response = ProductResponse.newBuilder()
                    .setId(request.getId())
                    .setName(request.getName())
                    .setPrice(request.getPrice())
                    .setDescription(request.getDescription())
                    .build();

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        }
    }
}
