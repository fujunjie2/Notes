package com.thread;




public class SynchronizedDemo {

    public static void main(String[] args) {

        SimpleClass firstObject = new SimpleClass();
        SimpleClass secondObject = new SimpleClass();

        /**
         * synchronized 修饰普通方法，锁的是当前方法所在的整个对象
         * 当有线程访问某个方法获取锁时，其它线程不仅无法访问这个方法，其它的同步方法也无法访问
         */
        Thread t1 = new Thread(new Task(firstObject, 1));
        Thread t2 = new Thread(new Task(firstObject, 2));

        t1.start();
        t2.start();

    }


}

class Task implements Runnable{

    private SimpleClass simpleClass;

    private int k;

    Task(SimpleClass simpleClass, int k ) {
        this.simpleClass = simpleClass;
        this.k = k;
    }

    @Override
    public void run() {
        if (k == 1) {
            simpleClass.way();
        } else {
            simpleClass.method();
        }
    }
}


class SimpleClass{

    public synchronized  void method() {
        try {
            System.out.println("get lock of method");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void way() {
        try {
            System.out.println("get lock of way");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}