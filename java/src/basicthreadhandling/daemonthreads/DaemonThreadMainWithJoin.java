package basicthreadhandling.daemonthreads;

public class DaemonThreadMainWithJoin {

    public static void main(String[] args) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.setDaemon(true);
        thread.start();
        thread.join();
        System.out.println("Main thread exiting.");
    }
}