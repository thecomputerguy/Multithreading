package threadunsafe;

import java.util.Random;

public class DemoThreadUnsafe {
    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws InterruptedException {
        ThreadUnsafeCounter badCounter = new ThreadUnsafeCounter();

        // create two threads and increment the counter in two threads
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.increment();
                    DemoThreadUnsafe.sleepRandomlyForLessThan10Seconds();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    badCounter.decrement();
                    DemoThreadUnsafe.sleepRandomlyForLessThan10Seconds();
                }
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        badCounter.printFinalCounterValue();
    }

    public static void sleepRandomlyForLessThan10Seconds() {

        try {
            Thread.sleep(random.nextInt(10));
        } catch (InterruptedException ex) {
            System.out.println("Exception : " + ex.getMessage());
        }
    }
}
