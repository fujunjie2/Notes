package com.inherit;

public class Main {

    public static void main(String[] args) {
        Credential c = new AsCredential("ak", "sk", "cn-global");


        if (c instanceof  AsCredential) {
            AsCredential as = (AsCredential) c;
            as.setRegion("aws-global");
        }

        System.out.println(1);


    }
}
