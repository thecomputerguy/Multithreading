package timer.timerwithexception;

import java.util.Timer;
import java.util.TimerTask;

public class TimerWithException {

    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        // Kills the only thread used by timer
        TimerTask taskWithException = new TimerTask() {

            @Override
            public void run() {
                throw new RuntimeException("Kill the only thread used by timer.");
            }
        };

        TimerTask goodTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("Good task");
            }
        };

        // Kills the only thread used by timer.
        timer.schedule(taskWithException, 500);
        Thread.sleep(500);
        // Never executes as the only thread used by timer is killed already.
        timer.schedule(goodTask, 700);

    }
}