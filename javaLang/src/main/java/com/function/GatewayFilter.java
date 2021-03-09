package com.function;


@FunctionalInterface
public interface GatewayFilter {

    GatewayFilter filter(GatewayExchange exchange, GatewayRequest request);
}
