package basicthreadhandling.threadinterrupts;

public class ExecuteMe implements Runnable {

    @Override
    public void run() {
        try {

            System.out.println("Inner thread goes to sleep at " + System.currentTimeMillis() / 1000);
            Thread.sleep(1000 * 1000);
        } catch (InterruptedException ex) {
            System.out.println("Inner thread woke up at " + System.currentTimeMillis() / 1000);
        }
    }
}