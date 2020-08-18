package missedsignals.problemusinglocks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MissedSignalExample {

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void example() throws InterruptedException {
        Thread signaller = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                System.out.println("Signaller is ready to signal.");
                condition.signal();
                System.out.println("Sent signal");
                lock.unlock();
            }
        });

        Thread waiter = new Thread(new Runnable() {

            @Override
            public void run() {
                lock.lock();
                try {
                    System.out.println("calling await.");
                    condition.await();
                    System.out.println("Done waiting. Recieved signal.");
                } catch (InterruptedException ex) {

                }
                lock.unlock();
            }
        });

        signaller.start();
        signaller.join();
        Thread.sleep(500);
        waiter.start();
        waiter.join();
        System.out.println("Exiting main thread.");

    }

}