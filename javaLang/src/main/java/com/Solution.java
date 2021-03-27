package com;

public class Solution {
    class Inner {
        public String  v1 = "Fake News";
        public String v2 = "Go ahead";

    }

    private static String GetVal() {
        try {
            return Inner.class.newInstance().v1;
        } catch (Exception e) {
            e.printStackTrace();
            try {
                return Inner.class.getDeclaredConstructor(Solution.class).newInstance((Solution)null).v2;
            } catch (Exception ee) {
                ee.printStackTrace();
                return "Fake News, Go ahead";
            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {

        Inner i = Inner.class.newInstance();

//        System.out.println(GetVal());
    }
 }