package com.thread.juc;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {

//        Thread t1 = new Thread(new JoinTask("join 线程1"));
//        Thread t2 = new Thread(new JoinTask("join 线程2"));
//        Thread t3 = new Thread(new JoinTask("join 线程3"));
//
//        t1.start();
//        t2.start();
//
//        t1.join();
//        t2.join();
//
//        t3.start();



        CountDownLatch countDownLatch = new CountDownLatch(2);


        Thread tc1 = new Thread(new CountDownTask("count 线程1", countDownLatch));
        Thread tc2 = new Thread(new CountDownTask("count 线程2", countDownLatch));
        Thread tc3 = new Thread(new CountDownTask("count 线程3", countDownLatch));

        tc1.start();
        tc2.start();

        countDownLatch.await();
        tc3.start();


    }
}

class JoinTask implements Runnable{

    private String taskName;

    JoinTask(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        System.out.println(taskName +  "开始");

        System.out.println(taskName +  "结束");
    }
}

class CountDownTask implements Runnable{

    private CountDownLatch countDownLatch;
    private String taskName;

    CountDownTask(String taskName, CountDownLatch latch) {
        this.taskName = taskName;
        this.countDownLatch = latch;
    }

    @Override
    public void run() {
        System.out.println(taskName +  "开始");
        countDownLatch.countDown();
        System.out.println(taskName +  "结束");
    }
}
