package semaphores.goodexample;

import java.util.concurrent.Semaphore;

public class SemaphoreGoodExample {

    private final static Semaphore SEMAPHORE = new Semaphore(1);

    public static void example() throws InterruptedException {

        Thread notifier = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Notifier is trying to acquire semaphore.");
                        SEMAPHORE.acquire();
                        System.out.println("Notifier has acquired semaphore.");
                        throw new RuntimeException("Notifier has thrown an exception.");
                    } catch (InterruptedException e) {

                    } finally {
                        SEMAPHORE.release();
                        System.out.println("Notifier has released semaphore in finally block.");
                    }
                    System.out.println("i am not Executed.");
                }
            }
        });

        notifier.start();
        Thread.sleep(1000);

        Thread waiter = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("waiter is acquiring semaphore.");
                try {

                    SEMAPHORE.acquire();
                    System.out.println("Waiter has acquired semaphore successfully.");
                } catch (Exception e) {

                }
                SEMAPHORE.release();
                System.out.println("Waiter has released semaphore.");
            }
        });

        waiter.start();
        waiter.join();
        System.out.println("Exiting main thread.");
    }
}