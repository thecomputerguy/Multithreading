package timer.timerwithbadtask;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
    // Single thread usage by timer.
    // good task never gets a chance to execute
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        TimerTask badTask = new TimerTask() {

            @Override
            public void run() {
                while (true) {
                    // run forever
                    System.out.println("Bad task.");
                }
            }
        };

        TimerTask goodTask = new TimerTask() {

            @Override
            public void run() {
                System.out.println("I am a well behaved task");
            }
        };

        timer.schedule(badTask, 100);
        timer.schedule(goodTask, 500);

        // By three seconds both tasks are expected to have launched
        Thread.sleep(3000);
    }
}