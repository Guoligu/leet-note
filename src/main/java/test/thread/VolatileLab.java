package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileLab {


    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                counter.add();
            }
        });
        t1.start();

        Thread t2 = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               counter.add();
           }
        });
        t2.start();


    }


}

class Counter {

    private int cnt = 0;
    private final Lock lock = new ReentrantLock();

    public void add() {
        lock.lock();
        try {
            cnt++;
            System.out.println(Thread.currentThread().getName() + ": " + cnt);
        } finally {
            lock.unlock();
        }

    }

    public void dec() {
        cnt--;
        System.out.println(Thread.currentThread().getName() + ": " + cnt);
    }

    public int getCnt() {
        return cnt;
    }
}
