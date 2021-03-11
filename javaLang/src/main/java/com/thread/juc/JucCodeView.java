package com.thread.juc;

import java.util.concurrent.locks.LockSupport;

public class JucCodeView {

    public static void main(String[] args) {
        LockSupport.park();
    }
}
