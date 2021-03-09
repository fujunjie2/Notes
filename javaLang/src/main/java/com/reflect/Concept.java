package com.reflect;

import com.pojo.Flowers;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;

public class Concept {


    public static void main(String[] args) {

        Flowers flowers = new Flowers();

        flowers.setColor("red");
        flowers.setHasLeaf(true);
        flowers.setHasFlower(true);
        flowers.setName("rose");

        Class fc = flowers.getClass();
        Class parentClass = fc.getSuperclass();

        ArrayList<Field> allFields = new ArrayList<>();

        Field[] parentField = parentClass.getDeclaredFields();


        Field[] fields = fc.getDeclaredFields();


        allFields.addAll(Arrays.asList(fields));
        allFields.addAll(Arrays.asList(parentField));

        for (Field field : allFields) {
            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                String name = field.getName();
                Object obj = field.get(flowers);
                System.out.println(name + "-" + obj);
            } catch (Exception e) {

            } finally {
                field.setAccessible(accessible);
            }
        }




    }
}
