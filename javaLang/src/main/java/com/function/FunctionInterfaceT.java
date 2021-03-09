package com.function;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionInterfaceT {


    public GatewayFilter apply() {
        return (exchange, request) -> {
            exchange.print();
            request.request();
            return null;
        };
    }


    public static void main(String[] args) {
        Function<Integer, String> f = (e) ->   String.valueOf(e +12);

        Predicate<String> expect = (e) ->  e.length() < 10 ;

        System.out.println(expect.test("dfdsf"));

        Optional optional = Optional.empty();
        optional.ifPresent((s) -> System.out.println());


    }

}

