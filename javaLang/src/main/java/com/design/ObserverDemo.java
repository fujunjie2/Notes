package com.design;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject s = new Subject();

        new BinaryObserver(s);
        new HexObserver(s);

        s.setState(1);
    }
}


abstract class Observer{
    protected Subject subject;
    public abstract void update();
}

class HexObserver extends Observer {

    HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("HexObserver observes: state change to" + subject.getState());
    }
}

class BinaryObserver extends Observer{
    private BinaryObserver() {};

    BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver Observes: state change to" + subject.getState());
    }
}


class Subject{

    private List<Observer> observerList = new ArrayList<>(4);

    private int state;

    public void attach(Observer observer) {
        this.observerList.add(observer);
    }

    private void notifyAllObserver() {
        observerList.forEach(e -> {
            e.update();
        });
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObserver();
    }

    public int getState() {
        return state;
    }


}