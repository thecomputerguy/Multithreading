package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class Worker extends Thread {

    private CountDownLatch countDownLatch;

    public Worker(CountDownLatch countDownLatch, String name) {
        super(name);
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println("Worker thread " + Thread.currentThread().getName() + " started.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Exception " + e.getMessage());
        }
        this.countDownLatch.countDown();
        System.out.println("Worker thread " + Thread.currentThread().getName() + " finished.");
    }
}