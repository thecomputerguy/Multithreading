package interrupts;

public class InterruptExample {

    public void example() throws InterruptedException {
        Thread sleepyThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {

                    System.out.println("Sleepy thread about to sleep for an hour");
                    Thread.sleep(1000 * 60 * 60);
                } catch (InterruptedException e) {
                    System.out.println("The interrupt flag is cleared " + Thread.interrupted() + " "
                            + Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();
                    System.out.println("Oh no someone woke me up!");
                    System.out.println(" Interrupt flag is set now " + Thread.currentThread().isInterrupted() + " "
                            + Thread.interrupted());
                    System.out.println("After the second Thread.interrupt() call interrupt is "
                            + Thread.currentThread().isInterrupted());
                }
            }
        });

        sleepyThread.start();
        Thread.sleep(500);
        System.out.println("About to wake up the sleepy thread.");
        sleepyThread.interrupt();
        System.out.println("Woke up the sleepy thread.");
        sleepyThread.join();

    }

    public static void runTest() throws InterruptedException {
        InterruptExample interruptExample = new InterruptExample();
        interruptExample.example();
    }
}