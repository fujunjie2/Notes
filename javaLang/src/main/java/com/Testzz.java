package com;

import java.util.HashMap;
import java.util.Map;

public class Testzz {

    public static void main(String[] args) {
        double r = mySqrt(3);
        System.out.println(r);
    }


    public static double mySqrt(int x) {
        double a = 1, diff = 0;

        do {
            a = (x / a + a) / 2.0;
            diff = Math.abs(a * a - x);
        } while (diff > 0.01);

        return   a;


    }
}
