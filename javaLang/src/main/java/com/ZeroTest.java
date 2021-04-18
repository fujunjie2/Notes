package com;

public class ZeroTest {

    public static void main(String[] args) {

        System.out.println(98 & -8);

        int sum = 0;
        for (int i = 0; i<20; i++) {
            sum += 0;

            if (i % 4 == 0) {
                break;
            }
        }

        System.out.println(sum);


        try {
            int i = 100 / 0;
        } catch (Exception e) {
            System.out.println(1);
            throw new RuntimeException();
        } finally {
            System.out.println(2);
        }

        System.out.println(3);
    }
}
