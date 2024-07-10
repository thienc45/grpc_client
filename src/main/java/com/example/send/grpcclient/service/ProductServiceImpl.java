package com.example.send.grpcclient.service;

import com.example.ecommerce.ProductIdRequest;
import com.example.ecommerce.ProductRequest;
import com.example.ecommerce.ProductResponse;
import com.example.ecommerce.ProductServiceGrpc;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class ProductServiceImpl extends ProductServiceGrpc.ProductServiceImplBase {
    @Override
    public void getProduct(ProductIdRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.getProduct(request, responseObserver);
    }

    @Override
    public void addProduct(ProductRequest request, StreamObserver<ProductResponse> responseObserver) {
        super.addProduct(request, responseObserver);
    }
}
