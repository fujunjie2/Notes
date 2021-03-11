package com.String;

public class TestEqual {

    public static void main(String[] args) {
        String a = "ab";
        String b = "a" + "b";
        System.out.println(a == b);

        String c = new String("a") + "b";

        System.out.println(b == c);
    }
}
