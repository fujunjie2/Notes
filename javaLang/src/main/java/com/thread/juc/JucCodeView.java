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

        CountDownLatch countDownLatch;

        Semaphore semaphore = new Semaphore(3);




        AtomicInteger atomicInteger;

        CopyOnWriteArrayList copyOnWriteArrayList;
        CopyOnWriteArraySet copyOnWriteArraySet;

        ReentrantLock reentrantLock;

        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();


        readWriteLock.writeLock().lock();
        System.out.println("write lock block");

        readWriteLock.writeLock().unlock();

        readWriteLock.readLock().lock();
        System.out.println("read lock block");

    }
}
