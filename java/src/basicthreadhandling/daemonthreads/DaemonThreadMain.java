package basicthreadhandling.daemonthreads;

public class DaemonThreadMain {

    public static void main(String[] args) {
        ExecuteMe executeMe = new ExecuteMe();
        Thread thread = new Thread(executeMe);
        thread.setDaemon(true);
        thread.start();
        System.out.println("Exiting main thread");
    }
}