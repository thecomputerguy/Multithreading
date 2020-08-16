package basicthreadhandling.nondaemonthreads;

public class NonDaemonThreadWithJoinMain {

    public static void main(String[] args) throws InterruptedException {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.start();
        thread.join();
        System.out.println("Main thread exiting.");
    }
}