package basicthreadhandling.nondaemonthreads;

public class NonDaemonThreadMain {

    public static void main(String[] args) {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.start();
        System.out.println("Main thread exiting.");
    }
}