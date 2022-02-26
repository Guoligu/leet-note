package test.thread;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolLab {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 10; i++) {
            executor.submit(new MyRunnable(i+""));
        }
        executor.shutdown();
    }
}

class MyRunnable implements Runnable {
    private String name;

    public MyRunnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("start " + name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end " + name);
    }
}