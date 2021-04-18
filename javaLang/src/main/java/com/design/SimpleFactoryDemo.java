package com.design;


public class SimpleFactoryDemo {


    public static void main(String[] args) {

        Car c1 = SimpleFactory.createCar("audi");
        Car c2 = SimpleFactory.createCar("bmw");

        c1.run();
        c2.run();
    }

}


class SimpleFactory{

    public static Car createCar(String type) {
         if (type.equals("audi")) {
            return new AoDi();
         } else if ("bmw".equals(type)) {
             return new Bmw();
         } else
             return null;
     }

}

interface Car{

    void run();
}

class Bmw implements Car{

    @Override
    public void run() {
        System.out.println("bmw");
    }
}

class AoDi implements Car{
    @Override
    public void run() {
        System.out.println("aodi");
    }
}