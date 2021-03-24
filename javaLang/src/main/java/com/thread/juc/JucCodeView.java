package com.thread.juc;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class JucCodeView {


    public static void main(String[] args) {

//        CountDownLatch countDownLatch;
//
//        Semaphore semaphore = new Semaphore(3);
//
//
//
//
//        AtomicInteger atomicInteger;
//
//        CopyOnWriteArrayList copyOnWriteArrayList;
//        CopyOnWriteArraySet copyOnWriteArraySet;
//
//        ReentrantLock reentrantLock;

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        // get read lock
        Thread t2 = new Thread(new ReadReadLockTask(2, readWriteLock));

        t2.start();


        Thread t1 = new Thread(new ReadReadLockTask(2, readWriteLock));

        t1.start();



    }
}

class ReadReadLockTask implements Runnable{

    private ReentrantReadWriteLock lock;

    private int lockType;

    ReadReadLockTask(int lockType, ReentrantReadWriteLock lock) {
        this.lockType = lockType;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            if (lockType == 1) {
                lock.writeLock().lock();
                System.out.println("get write lock");
            } else {
                lock.readLock().lock();
                System.out.println("get read lock");
            }
            Thread.sleep(3000);
        } catch (Exception e) {

        }finally {
            if (lockType == 1)
                lock.writeLock().unlock();
            else
                lock.readLock().unlock();
        }
    }
}
