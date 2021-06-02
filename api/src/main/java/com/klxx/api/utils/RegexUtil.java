package com.klxx.api.utils;

public class RegexUtil {

    public static void main(String[] args) {
       String replaced =  emailReplace("2@outlook.com");
        System.out.println(replaced);
    }


    public static String emailReplace(String email) {
        String[] emailComponent = email.split("@");
        String alias = emailComponent[0];
        int len = alias.length();
        StringBuilder sb = new StringBuilder();
        if (len == 1) {
            return sb.append(alias).append("***").append(emailComponent[1]).toString();
        }
        if (len == 2) {
            return sb.append(alias.charAt(0)).append("***").append(emailComponent[1]).toString();
        }
        int low = len/2;
        int high = low + 1;


        return null;
    }
}
