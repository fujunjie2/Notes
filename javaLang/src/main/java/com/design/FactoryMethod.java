package com.design;

public class FactoryMethod {

    public static void main(String[] args) {

        Car bmw = new BmwFactory().createCar();

        Car audi = new AudiFactory().createCar();

        bmw.run();
        audi.run();

    }

}


interface Factory{
    Car createCar();
}

class BmwFactory implements  Factory{
    @Override
    public Car createCar() {
        return new Bmw();
    }
}

class AudiFactory implements Factory{
    @Override
    public Car createCar() {
        return new AoDi();
    }
}