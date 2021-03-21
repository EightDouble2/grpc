package com.johnny.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class CalculationClient {
    ManagedChannel channel;
    CalculationServiceGrpc.CalculationServiceBlockingStub stub;

    public static void main(String[] args) {
        CalculationClient calculationClient = new CalculationClient();

        AddResponse addResponse = calculationClient.stub.add(AddRequest.newBuilder().setA(1).setB(2).build());
        System.out.println(addResponse.getResult());

        SubResponse subResponse = calculationClient.stub.sub(SubRequest.newBuilder().setA(2).setB(1).build());
        System.out.println(subResponse.getResult());
    }

    public CalculationClient() {
        channel = ManagedChannelBuilder
                .forAddress("127.0.0.1", 9999)
                .usePlaintext()
                .build();
        stub = CalculationServiceGrpc.newBlockingStub(channel);
    }
}
