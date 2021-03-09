package com.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

public class TestSpi {

    public static void main(String[] args) {
        ServiceLoader<Discount> serviceLoader = ServiceLoader.load(Discount.class);

        Iterator<Discount> iterator = serviceLoader.iterator();
        while (iterator.hasNext()) {
            System.out.println(1);
            Discount discount = iterator.next();
            discount.calculate(500, 200);
        }

    }
}
