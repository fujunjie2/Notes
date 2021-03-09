package com.rt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Hh {

    static final int hash = 0;

    public static void main(String[] args) {


        int[] table = new int[]{1,2,3,4,5};

        int[] oldTab = table;

        table = new int[]{6,7,8,9,10};

        System.out.println(oldTab[0]);
        System.out.println(table[0]);
    }



}
