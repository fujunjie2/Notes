package com.klxx.api.bdmap.utils;

import java.io.File;

public class PathTest {

    public static void main(String[] args) {

        File f = new File("D://busketball.xls");

        System.out.println(f.exists());
    }
}
