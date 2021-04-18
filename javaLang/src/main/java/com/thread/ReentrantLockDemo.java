package com.thread;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        LockClass lockClass = new LockClass(lock);

        Thread t1 = new Thread(new LockTask(lockClass, 1));
        Thread t2 = new Thread(new LockTask(lockClass, 2));

        t1.start();
        t2.start();

    }
}



class LockClass{

    private ReentrantLock lock;

    LockClass(ReentrantLock lock) {
        this.lock = lock;
    }

    public  void method() {
        try {
            lock.lock();
            System.out.println("get lock of method");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void way() {
        try {
            lock.lock();
            System.out.println("get lock of way");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

class LockTask implements Runnable{


    private LockClass lockClass;

    private int k;

    LockTask(LockClass simpleClass,  int k) {
        this.lockClass = simpleClass;
        this.k = k;
    }

    @Override
    public void run() {
        if (k == 1) {
            lockClass.way();
        } else {
            lockClass.method();
        }
    }
}