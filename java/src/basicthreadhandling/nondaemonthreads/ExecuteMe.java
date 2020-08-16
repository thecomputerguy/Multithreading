package basicthreadhandling.nondaemonthreads;

public class ExecuteMe implements Runnable {

    @Override
    public void run() {
        System.out.println("Inner thread is running");
    }
}