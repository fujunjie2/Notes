package com.function;

public class Test1 {

    public static void main(String[] args) {

        FunctionInterfaceT t1 = new FunctionInterfaceT();

        GatewayFilter g1 = t1.apply();

        g1.filter(new GatewayExchange(), new GatewayRequest());

    }
}
