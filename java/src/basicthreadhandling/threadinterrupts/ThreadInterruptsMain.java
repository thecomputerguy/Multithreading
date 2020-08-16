package basicthreadhandling.threadinterrupts;

public class ThreadInterruptsMain {

    public static void main(String[] args) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.start();
        System.out.println("Main thread goes to sleep at " + System.currentTimeMillis() / 1000);
        Thread.sleep(5000);
        thread.interrupt();
        System.out.println("Main thread woke up at " + System.currentTimeMillis() / 1000);
    }
}