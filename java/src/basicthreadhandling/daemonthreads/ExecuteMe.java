package basicthreadhandling.daemonthreads;

public class ExecuteMe implements Runnable {

    @Override
    public void run() {
        // perpetual loop to keep it running.
        while (true) {
            try {

                System.out.println("Message from daemon thread");
                Thread.sleep(500);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}