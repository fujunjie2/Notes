package com.design;

public class AbstractFactoryMethod {

}

interface TotalFactory{

    Car createCar();

    Engine createEngine();

}

class TotalFactoryImpl implements TotalFactory{

    @Override
    public Car createCar() {
        return null;
    }

    @Override
    public Engine createEngine() {
        return null;
    }
}


interface Engine{

    void runEngine();
}

class EngineA implements Engine{

    @Override
    public void runEngine() {
        System.out.println("run faster");
    }
}

class EngineB implements Engine{
    @Override
    public void runEngine() {
        System.out.println("run slower");
    }
}