package synchronization.incorrect;

public class IncorrectSynchronization {

    private Boolean flag = new Boolean(true);

    public void example() throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
                synchronized (flag) {
                    try {

                        while (flag) {
                            System.out.println("First thread about to be put to sleep.");
                            Thread.sleep(5000);
                            System.out.println("First thread woke up and about to call wait");
                            flag.wait();
                            System.out.println("Started working after waiting.");
                        }
                    } catch (InterruptedException e) {

                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {

            @Override
            public void run() {
                flag = false;
                System.out.println("Boolean value set to false.");
            }
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
        thread1.join();
        thread2.join();
    }

    public static void runTest() throws InterruptedException {
        IncorrectSynchronization incSync = new IncorrectSynchronization();
        incSync.example();
    }
}