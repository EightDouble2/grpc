package com.johnny.grpc;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;

import java.io.IOException;

public class CalculationService extends CalculationServiceGrpc.CalculationServiceImplBase {

    public static void main(String[] args) throws IOException {
        ServerBuilder.forPort(9999)
                .addService(new CalculationService())
                .build()
                .start();

        while (true) {

        }
    }

    @Override
    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        int result = request.getA() + request.getB();
        responseObserver.onNext(AddResponse.newBuilder().setResult(result).build());
        responseObserver.onCompleted();
    }

    @Override
    public void sub(SubRequest request, StreamObserver<SubResponse> responseObserver) {
        int result = request.getA() - request.getB();
        responseObserver.onNext(SubResponse.newBuilder().setResult(result).build());
        responseObserver.onCompleted();
    }
}
