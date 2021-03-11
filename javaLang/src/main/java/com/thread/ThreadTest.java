package com.thread;

public class ThreadTest {

    public static void main(String[] args) {
        int start = 0;
        int end = 999;

        int middle = (start + end / 2);

        System.out.println(middle);
    }

    public static void recursive(int start, int end) {
        if (start < end && end - start < 50) {
            return;
        }
        System.out.println();
    }
}


