package missedsignals.solutionusingsemaphores;

import java.util.concurrent.Semaphore;

public class MissedSignalSolutionUsingSemaphores {

    private static Semaphore semaphore = new Semaphore(1);

    public static void example() throws InterruptedException {

        Thread signaller = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Signaller is ready to send signal");
                semaphore.release();
                System.out.println("Signaller has sent notification.");
            }
        });

        Thread waiter = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Ready to acquire semaphore.");
                try {

                    semaphore.acquire();
                } catch (Exception e) {

                }
                System.out.println("Acquired semaphore.");
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