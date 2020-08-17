package countdownlatch;

import java.util.concurrent.CountDownLatch;

public class WorkerMasterMain {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Worker worker1 = new Worker(countDownLatch, "Worker1");
        Worker worker2 = new Worker(countDownLatch, "Worker2");
        worker1.start();
        worker2.start();

        countDownLatch.await();
        Master master = new Master("master");
        master.start();
        System.out.println("Main thread finished execution.");
    }
}