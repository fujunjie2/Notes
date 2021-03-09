package com.String;

public class StringExmp {

    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");

        String c = a.intern();

        System.out.println( a == b);
        System.out.println( c == b);
        System.out.println( a == c);
    }
}
