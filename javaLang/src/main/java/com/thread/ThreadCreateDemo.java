package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadCreateDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("a ");
            }
        });

        Thread t = new Thread(new ThreadTask());

        Thread r = new Thread(new RunnableTask());

        FutureTask<Integer> futureTask = new FutureTask<>(new CallAbleTask());
        Thread c = new Thread(futureTask);

        t.start();
        r.start();
        c.start();


        System.out.println(futureTask.get());



    }
}

class ThreadTask extends Thread{

    @Override
    public void run() {
        System.out.println("thread");
    }
}

class RunnableTask implements Runnable{

    @Override
    public void run() {
        System.out.println("runnable");
    }
}

class CallAbleTask implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("callable");
        return 1;
    }
}