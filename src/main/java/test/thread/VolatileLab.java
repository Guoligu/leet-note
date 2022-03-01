package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class VolatileLab {

    static int cnt = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {

            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    sleep(10);
                    cnt++;
                }
            }).start();

        }


        sleep(1000);
        System.out.println(cnt);
    }

    public static void sleep(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
