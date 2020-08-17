package countdownlatch;

public class Master extends Thread {

    public Master(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Master thread " + Thread.currentThread().getName() + " Started.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("Exception " + e.getMessage());
        }

        System.out.println("Master thread " + Thread.currentThread().getName() + " Finished.");
    }
}