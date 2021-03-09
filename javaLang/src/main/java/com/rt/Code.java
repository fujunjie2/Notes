package com.rt;

public class Code {

    public static void main(String[] args) {

        int k = "jdfdf".hashCode();

        int low16 = k >>> 16;

        System.out.println(k);
        System.out.println(Integer.toBinaryString(k));
        System.out.println(Integer.toBinaryString(low16));

        int orx = k ^ low16;

        System.out.println(orx);
        System.out.println(Integer.toBinaryString(orx));
    }
}
