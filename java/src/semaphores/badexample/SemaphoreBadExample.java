package semaphores.badexample;

import java.util.concurrent.Semaphore;

public class SemaphoreBadExample {

    private static final Semaphore semaphore = new Semaphore(1);

    public static void example() throws InterruptedException {

        Thread notifier = new Thread(new Runnable() {

            @Override
            public void run() {

                while (true) {
                    System.out.println("Notifier started ");
                    try {

                        semaphore.acquire();
                    } catch (InterruptedException e) {

                    }
                    throw new RuntimeException("Thread throws an exception.");
                    // semaphore.release();
                }

            }
        });

        notifier.start();
        Thread.sleep(1000);

        Thread waiter = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Waiter trying to acquire semaphore.");
                try {

                    semaphore.acquire();
                    System.out.println("Waiter acquired semaphore successfully.");
                } catch (InterruptedException e) {

                }

                semaphore.release();
            }
        });

        waiter.start();
        waiter.join();
        System.out.println("Exiting main thread.");
    }
}